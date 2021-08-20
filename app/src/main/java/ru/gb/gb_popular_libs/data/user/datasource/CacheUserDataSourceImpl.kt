package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.gb.gb_popular_libs.data.di.InMemory
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import ru.gb.gb_popular_libs.data.model.GitHubUser
import javax.inject.Inject

class CacheUserDataSourceImpl @Inject constructor(
    @InMemory private val gitHubStorage: GitHubStorage
) : CacheUserDataSource {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUserByLogin(userId)
            .toMaybe()

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .retain(user)
            .andThen(Single.just(user))

}