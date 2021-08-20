package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Single
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface CacheUserDataSource : UserDataSource {

    fun retain(user: GitHubUser): Single<GitHubUser>

}