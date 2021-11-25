package ru.gb.gb_popular_libs.presentation

import androidx.annotation.ColorRes
import ru.gb.gb_popular_libs.data.user.GitHubUser

data class GitHubUserViewModel(
    val login: String,
    val name: String,
    val avatar: String,
    val type: GitHubUser.Type
) {

    @ColorRes
    val nameColor: Int =
        when (type) {
            GitHubUser.Type.USER -> android.R.color.black
            GitHubUser.Type.ADMINISTRATOR -> android.R.color.holo_red_dark
            GitHubUser.Type.UNKNOWN -> android.R.color.darker_gray
        }

    object Mapper {

        fun map(user: GitHubUser) =
            GitHubUserViewModel(
                user.login,
                user.name ?: user.login,
                user.avatar,
                user.type
            )

    }

}