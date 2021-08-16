package ru.gb.gb_popular_libs.data.user

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.UserDataSource
import java.util.concurrent.TimeUnit

class GitHubUserRepositoryImpl(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            cloud.getUsers().flatMap(cache::retain).toObservable()
        )

//        cache.getUsers()
//            .flatMap { users ->
//                if (users.isEmpty()) {
//                    cloud.getUsers()
//                        .flatMap(cache::retain)
//                } else {
//                    Single.just(users)
//                }
//            }
            //.map { users -> users.map { it.copy(login = it.login.lowercase()) } }

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.getUserByLogin(userId)
            .onErrorResumeNext(
                cloud.getUserByLogin(userId)
            )

}