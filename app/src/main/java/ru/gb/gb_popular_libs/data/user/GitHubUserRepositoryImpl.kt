package ru.gb.gb_popular_libs.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.api.GitHubApiFactory

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi = GitHubApiFactory.create()
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi
            .fetchUserByLogin(userId)
            .onErrorComplete()

}