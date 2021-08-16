package ru.gb.gb_popular_libs.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_user")
data class GitHubUser(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "login")
    @SerializedName("login")
    val login: String,
    @ColumnInfo(name = "avatar")
    @SerializedName("avatar_url")
    val avatar: String,
    @ColumnInfo(name = "migrate")
    val migrate: String?,
)