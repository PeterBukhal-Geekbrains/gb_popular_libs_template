package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.model.GitHubUser
import javax.inject.Inject

class CloudUserDataSource @Inject constructor(
    private val gitHubApi: GitHubApi,
) : UserDataSource {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}