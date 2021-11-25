package ru.gb.gb_popular_libs.data.repository.datasource

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

interface GitHubRepositoryCacheDataSource {

    fun getUserRepositories(login: String): Observable<List<GitHubRepository>>
    fun retain(repositories: List<GitHubRepository>): Completable

}