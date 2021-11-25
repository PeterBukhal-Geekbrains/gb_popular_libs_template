package ru.gb.gb_popular_libs.data.user

import ru.gb.gb_popular_libs.data.api.GitHubApiFactory
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryCacheDataSourceImpl
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryDataSourceImpl
import ru.gb.gb_popular_libs.data.storage.GitHubStorageFactory
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserCacheDataSourceImpl
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserDataSourceImpl
import kotlin.LazyThreadSafetyMode.NONE

/**
 * Пока нет DI на основе Dagger2 мы решаем проблему
 * по старинке используя фабрики.
 */
object GitHubUserRepositoryFactory {

    private val gitHubUserRepository: GitHubUserRepository by lazy(NONE) {
        GitHubUserRepositoryImpl(
            GitHubUserDataSourceImpl(
                GitHubApiFactory.create()
            ),
            GitHubUserCacheDataSourceImpl(
                GitHubStorageFactory.create()
            ),
            GitHubRepositoryDataSourceImpl(
                GitHubApiFactory.create()
            ),
            GitHubRepositoryCacheDataSourceImpl(
                GitHubStorageFactory.create()
            )
        )
    }

    fun create(): GitHubUserRepository = gitHubUserRepository

}