package ru.gb.gb_popular_libs.data.repository.datasource

import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import javax.inject.Inject

class GitHubRepositoryDataSourceImpl
@Inject constructor(
    private val gitHubApi: GitHubApi
): GitHubRepositoryDataSource {

    override fun getUserRepositories(userId: String): Single<List<GitHubRepository>> =
        gitHubApi
            .fetchUserRepositories(userId)

}