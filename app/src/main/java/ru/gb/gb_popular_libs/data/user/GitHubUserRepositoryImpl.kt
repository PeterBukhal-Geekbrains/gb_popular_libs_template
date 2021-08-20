package ru.gb.gb_popular_libs.data.user

import io.reactivex.Maybe
import ru.gb.gb_popular_libs.data.model.GitHubUser
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.UserDataSource
import javax.inject.Inject

class GitHubUserRepositoryImpl @Inject constructor(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource
) : GitHubUserRepository {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cloud.getUserByLogin(userId)
            .flatMap { cache.retain(it).toMaybe() }

}