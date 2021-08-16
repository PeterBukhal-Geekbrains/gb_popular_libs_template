package ru.gb.gb_popular_libs.data.user

import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSourceFactory
import ru.gb.gb_popular_libs.data.user.datasource.UserDataSourceFactory

/**
 * Пока нет DI на основе Dagger2 мы решаем проблему
 * по старинке используя фабрики.
 */
object GitHubUserRepositoryFactory {

    private val repository: GitHubUserRepository by lazy {
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )
    }

    fun create(): GitHubUserRepository = repository

}