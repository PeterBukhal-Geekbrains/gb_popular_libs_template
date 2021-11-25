package ru.gb.gb_popular_libs.data.repository.datasource

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.data.storage.GitHubStorage

class GitHubRepositoryCacheDataSourceImpl(
    private val gitHubStorage: GitHubStorage
): GitHubRepositoryCacheDataSource {

    override fun getUserRepositories(login: String): Observable<List<GitHubRepository>> =
        gitHubStorage
            .getGitHubRepositoryDao()
            .getRepositoriesByLogin(login)

    override fun retain(repositories: List<GitHubRepository>): Completable =
        gitHubStorage
            .getGitHubRepositoryDao()
            .retain(repositories)

}