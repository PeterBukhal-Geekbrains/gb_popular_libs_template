package ru.gb.gb_popular_libs.data.di.modules

import dagger.Binds
import dagger.Module
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryImpl
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSourceImpl
import ru.gb.gb_popular_libs.data.user.datasource.CloudUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.UserDataSource
import ru.gb.gb_popular_libs.data.users.GitHubUsersRepository
import ru.gb.gb_popular_libs.data.users.GitHubUsersRepositoryImpl

@Module(includes = [GitHubStorageModule::class, GitHubApiModule::class])
interface GitHubUserRepositoryModule {

    @Binds
    fun bindGitHubUserRepository(repository: GitHubUserRepositoryImpl): GitHubUserRepository

    @Binds
    fun bindUserDataSource(dataSource: CloudUserDataSource): UserDataSource

    @Binds
    fun bindCacheUserDataSource(dataSource: CacheUserDataSourceImpl): CacheUserDataSource

}