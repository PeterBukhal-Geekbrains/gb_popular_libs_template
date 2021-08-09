package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Single
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface CacheUserDataSource : UserDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>

}