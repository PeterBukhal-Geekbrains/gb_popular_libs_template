package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface UserDataSource {

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}