package ru.gb.gb_popular_libs.presentation

import ru.gb.gb_popular_libs.data.user.GitHubUser

data class GitHubUserViewModel(
    val login: String,
    val avatar: String
) {

    object Mapper {

        fun map(user: GitHubUser) =
            GitHubUserViewModel(
                user.login.uppercase(),
                user.avatar
            )

    }

}