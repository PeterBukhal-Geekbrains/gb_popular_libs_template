package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface GitHubUserCacheDataSource {

    fun getUsers(): Observable<List<GitHubUser>>
    fun getUserByLogin(login: String): Observable<GitHubUser>
    fun retain(users: List<GitHubUser>): Observable<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>

}