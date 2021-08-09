package ru.gb.gb_popular_libs.data.user.datasource

import ru.gb.gb_popular_libs.data.api.GitHubApiFactory

object UserDataSourceFactory {

    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())

}