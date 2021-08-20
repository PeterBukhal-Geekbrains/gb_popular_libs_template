package ru.gb.gb_popular_libs.data.users.datasource

import io.reactivex.Observable
import io.reactivex.Single
import ru.gb.gb_popular_libs.data.di.InMemory
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import ru.gb.gb_popular_libs.data.model.GitHubUser
import javax.inject.Inject

class CacheUsersDataSourceImpl @Inject constructor(
    @InMemory private val gitHubStorage: GitHubStorage
) : CacheUsersDataSource {

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUsers()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .retain(users)
            .andThen(getUsers().firstOrError())

}