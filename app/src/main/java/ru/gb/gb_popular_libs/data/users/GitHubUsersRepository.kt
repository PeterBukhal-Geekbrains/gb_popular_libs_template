package ru.gb.gb_popular_libs.data.users

import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface GitHubUsersRepository {

    fun getUsers(): Observable<List<GitHubUser>>

}