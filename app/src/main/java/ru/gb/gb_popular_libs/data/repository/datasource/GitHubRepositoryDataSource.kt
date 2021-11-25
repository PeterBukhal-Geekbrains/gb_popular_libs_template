package ru.gb.gb_popular_libs.data.repository.datasource

import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

interface GitHubRepositoryDataSource {

    fun getUserRepositories(userId: String): Single<List<GitHubRepository>>

}