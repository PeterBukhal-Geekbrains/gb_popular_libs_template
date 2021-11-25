package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.user.GitHubUser
import java.util.concurrent.TimeUnit.SECONDS

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi
) : GitHubUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()
            .delay(2L, SECONDS)

    override fun getUserByLogin(login: String): Maybe<GitHubUser> =
        gitHubApi
            .fetchUserByLogin(login)
            .onErrorComplete()

}