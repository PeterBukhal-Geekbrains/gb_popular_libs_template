package ru.gb.gb_popular_libs.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_users")
data class GitHubUser(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @ColumnInfo
    @SerializedName("login")
    val login: String,
    @ColumnInfo
    @SerializedName("name")
    val name: String?,
    @ColumnInfo
    @SerializedName("avatar_url")
    val avatar: String,
) {

    @Ignore
    @SerializedName("type")
    val type: Type = Type.USER

    enum class Type {
        USER,
        ADMINISTRATOR,
        UNKNOWN
    }

}