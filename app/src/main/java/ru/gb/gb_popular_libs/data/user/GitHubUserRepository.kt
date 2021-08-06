package ru.gb.gb_popular_libs.data.user

import io.reactivex.Maybe
import io.reactivex.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}