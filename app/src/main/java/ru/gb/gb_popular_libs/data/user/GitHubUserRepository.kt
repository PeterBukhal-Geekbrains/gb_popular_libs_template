package ru.gb.gb_popular_libs.data.user

import io.reactivex.rxjava3.core.Observable
import ru.gb.gb_popular_libs.data.repository.GitHubRepository

interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUser(userId: String): Observable<GitHubUser>

    fun getUserRepositories(login: String): Observable<List<GitHubRepository>>

}