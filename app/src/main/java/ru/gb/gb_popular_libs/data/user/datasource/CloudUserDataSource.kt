package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.user.GitHubUser

class CloudUserDataSource(private val gitHubApi: GitHubApi) : UserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi.getUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}