package ru.gb.gb_popular_libs.data.user

import io.reactivex.rxjava3.core.Observable
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryCacheDataSource
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryDataSource
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserCacheDataSource
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserDataSource

class GitHubUserRepositoryImpl(
    private val gitHubUserDataSource: GitHubUserDataSource,
    private val gitHubUserCacheDataSource: GitHubUserCacheDataSource,
    private val gitHubRepositoryDataSource: GitHubRepositoryDataSource,
    private val gitHubRepositoryCacheDataSource: GitHubRepositoryCacheDataSource,
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            gitHubUserCacheDataSource
                .getUsers(),
            gitHubUserDataSource
                .getUsers()
                .flatMapObservable(gitHubUserCacheDataSource::retain)
        )

    override fun getUser(userId: String): Observable<GitHubUser> =
        Observable.merge(
            gitHubUserCacheDataSource
                .getUserByLogin(userId),
            gitHubUserDataSource
                .getUserByLogin(userId)
                .flatMapCompletable { user ->
                    gitHubUserCacheDataSource
                        .retain(user)
                        .flatMapCompletable {
                            gitHubRepositoryDataSource
                                .getUserRepositories(user.login)
                                .map { repositories -> repositories.map { repository -> repository.copy(login = user.login) }}
                                .flatMapCompletable(gitHubRepositoryCacheDataSource::retain)
                        }
                }
                .toObservable()
        )

    override fun getUserRepositories(login: String): Observable<List<GitHubRepository>> =
        Observable.merge(
            gitHubRepositoryCacheDataSource
                .getUserRepositories(login),
            gitHubRepositoryDataSource
                .getUserRepositories(login)
                .map { repositories -> repositories.map { repository -> repository.copy(login = login) }}
                .flatMapCompletable(gitHubRepositoryCacheDataSource::retain)
                .toObservable()
        )

}