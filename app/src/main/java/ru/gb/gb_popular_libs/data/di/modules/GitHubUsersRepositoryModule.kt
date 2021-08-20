package ru.gb.gb_popular_libs.data.di.modules

import dagger.Binds
import dagger.Module
import ru.gb.gb_popular_libs.data.users.GitHubUsersRepository
import ru.gb.gb_popular_libs.data.users.GitHubUsersRepositoryImpl
import ru.gb.gb_popular_libs.data.users.datasource.CacheUsersDataSource
import ru.gb.gb_popular_libs.data.users.datasource.CacheUsersDataSourceImpl
import ru.gb.gb_popular_libs.data.users.datasource.CloudUsersDataSource
import ru.gb.gb_popular_libs.data.users.datasource.UsersDataSource

@Module(includes = [GitHubStorageModule::class, GitHubApiModule::class])
interface GitHubUsersRepositoryModule {

    @Binds
    fun bindGitHubUsersRepository(repository: GitHubUsersRepositoryImpl): GitHubUsersRepository

    @Binds
    fun bindUsersDataSource(dataSource: CloudUsersDataSource): UsersDataSource

    @Binds
    fun bindCacheUsersDataSource(dataSource: CacheUsersDataSourceImpl): CacheUsersDataSource

}