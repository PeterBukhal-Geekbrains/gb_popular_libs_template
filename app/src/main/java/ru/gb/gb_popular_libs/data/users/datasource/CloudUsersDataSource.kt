package ru.gb.gb_popular_libs.data.users.datasource

import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.model.GitHubUser
import javax.inject.Inject

class CloudUsersDataSource @Inject constructor(
    private val gitHubApi: GitHubApi,
) : UsersDataSource {

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubApi
            .getUsers()
            .toObservable()

}