package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface GitHubUserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(login: String): Maybe<GitHubUser>

}