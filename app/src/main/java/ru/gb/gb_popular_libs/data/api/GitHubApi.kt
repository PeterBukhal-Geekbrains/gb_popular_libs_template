package ru.gb.gb_popular_libs.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gb.gb_popular_libs.data.model.GitHubUser

interface GitHubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<GitHubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GitHubUser>

}