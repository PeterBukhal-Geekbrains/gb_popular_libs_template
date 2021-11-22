package ru.gb.gb_popular_libs.data.user

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("type")
    val type: Type
) {

    enum class Type {
        USER,
        ADMINISTRATOR,
        UNKNOWN
    }

}