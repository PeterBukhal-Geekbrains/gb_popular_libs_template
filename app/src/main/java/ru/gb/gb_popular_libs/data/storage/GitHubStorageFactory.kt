package ru.gb.gb_popular_libs.data.storage

import androidx.room.Room
import ru.gb.gb_popular_libs.PopularLibraries.ContextHolder.context
import ru.gb.gb_popular_libs.data.storage.migration.GitHub1to2Migration
import ru.gb.gb_popular_libs.data.storage.migration.GitHub2to3Migration

object GitHubStorageFactory {

    private val inMemoryDatabase: GitHubStorage by lazy {
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
    }

    private val database: GitHubStorage by lazy {
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            //.addMigrations(GitHub1to2Migration)
            //.addMigrations(GitHub2to3Migration)
            .build()
    }

    fun create(): GitHubStorage = database

}