package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import ru.gb.gb_popular_libs.data.user.GitHubUser
import javax.inject.Inject
import javax.inject.Named

class GitHubUserCacheDataSourceImpl
@Inject constructor(
    @Named("Persisted") private val gitHubStorage: GitHubStorage
) : GitHubUserCacheDataSource {

    override fun retain(users: List<GitHubUser>): Observable<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(users)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getUsers()
            )

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(user)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getUserByLogin(user.login)
                    .firstOrError()
            )

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .getUsers()

    override fun getUserByLogin(login: String): Observable<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .getUserByLogin(login)

}