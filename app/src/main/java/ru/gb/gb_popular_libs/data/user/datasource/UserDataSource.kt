package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface UserDataSource {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}