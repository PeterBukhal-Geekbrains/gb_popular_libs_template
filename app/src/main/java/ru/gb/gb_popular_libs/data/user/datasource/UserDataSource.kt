package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface UserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}