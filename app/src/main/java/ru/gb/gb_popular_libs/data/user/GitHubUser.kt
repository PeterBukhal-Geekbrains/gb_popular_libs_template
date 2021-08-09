package ru.gb.gb_popular_libs.data.user

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("id") val id: String,
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatar: String
)