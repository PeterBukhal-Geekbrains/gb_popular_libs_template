package ru.gb.gb_popular_libs.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.gb.gb_popular_libs.data.storage.GitHubStorage
import javax.inject.Named
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Named("InMemory")
    @Provides
    fun provideInMemoryDatabase(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Named("Persisted")
    @Provides
    fun providePersistedDatabase(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .build()

}