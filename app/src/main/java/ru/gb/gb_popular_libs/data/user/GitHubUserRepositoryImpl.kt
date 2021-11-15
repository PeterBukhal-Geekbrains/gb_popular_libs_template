package ru.gb.gb_popular_libs.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val users = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
    )

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(users)
            .map { users -> users.map { it.copy(login = it.login.lowercase()) } }

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        users.firstOrNull { user -> user.login.contentEquals(userId, ignoreCase = true) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()

}