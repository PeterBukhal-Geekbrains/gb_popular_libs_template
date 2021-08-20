package ru.gb.gb_popular_libs.data.users.datasource

import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface UsersDataSource {

    fun getUsers(): Observable<List<GitHubUser>>

}