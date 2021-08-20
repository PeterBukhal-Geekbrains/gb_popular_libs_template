package ru.gb.gb_popular_libs.data.user

import io.reactivex.Maybe
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface GitHubUserRepository {

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}