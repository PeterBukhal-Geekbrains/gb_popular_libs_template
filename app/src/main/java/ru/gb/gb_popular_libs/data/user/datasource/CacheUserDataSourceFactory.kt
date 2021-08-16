package ru.gb.gb_popular_libs.data.user.datasource

import ru.gb.gb_popular_libs.PopularLibraries.ContextHolder
import ru.gb.gb_popular_libs.data.storage.GitHubStorageFactory

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(
            GitHubStorageFactory.createInMemory(ContextHolder.context)
        )

}