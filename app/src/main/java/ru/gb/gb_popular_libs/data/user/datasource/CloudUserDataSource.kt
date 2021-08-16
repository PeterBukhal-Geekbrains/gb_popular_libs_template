package ru.gb.gb_popular_libs.data.user.datasource

import io.reactivex.Maybe
import io.reactivex.Observable
import ru.gb.gb_popular_libs.data.api.GitHubApi
import ru.gb.gb_popular_libs.data.di.InMemory
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import ru.gb.gb_popular_libs.data.user.GitHubUser
import javax.inject.Inject

class CloudUserDataSource @Inject constructor(
    private val gitHubApi: GitHubApi,
    @InMemory private val gitHubStorage: GitHubStorage
) : UserDataSource {

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubApi
            .getUsers()
            .toObservable()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}