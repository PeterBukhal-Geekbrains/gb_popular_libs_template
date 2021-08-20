package ru.gb.gb_popular_libs.data.users

import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.model.GitHubUser
import ru.gb.gb_popular_libs.data.users.datasource.CacheUsersDataSource
import ru.gb.gb_popular_libs.data.users.datasource.UsersDataSource
import javax.inject.Inject

class GitHubUsersRepositoryImpl @Inject constructor(
    private val cloud: UsersDataSource,
    private val cache: CacheUsersDataSource
) : GitHubUsersRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers(),
            cloud.getUsers().flatMapSingle(cache::retain)
        )

}