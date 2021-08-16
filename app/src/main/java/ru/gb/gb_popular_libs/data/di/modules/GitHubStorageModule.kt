package ru.gb.gb_popular_libs.data.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.gb.gb_popular_libs.data.di.InMemory
import ru.gb.gb_popular_libs.data.di.Persisted
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import ru.gb.gb_popular_libs.data.storage.migration.GitHub1to2Migration
import ru.gb.gb_popular_libs.data.storage.migration.GitHub2to3Migration

@Module
class GitHubStorageModule {

    @Persisted
    @Provides
    fun provideGitHubDatabaseStorage(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration, GitHub2to3Migration)
            .build()

    @InMemory
    @Provides
    fun provideGitHubInMemoryDatabaseStorage(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

}