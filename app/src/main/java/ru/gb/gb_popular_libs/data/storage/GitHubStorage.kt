package ru.gb.gb_popular_libs.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.data.user.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepository::class], version = 1)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao
    abstract fun getGitHubRepositoryDao(): GitHubRepositoryDao

}