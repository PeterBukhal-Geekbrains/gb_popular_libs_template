package ru.gb.gb_popular_libs.data.users.datasource

import io.reactivex.Single
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface CacheUsersDataSource : UsersDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>

}