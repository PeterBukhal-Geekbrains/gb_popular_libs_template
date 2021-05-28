package ru.gb.gb_popular_libs.data.user

interface GitHubUserRepository {

    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?

}