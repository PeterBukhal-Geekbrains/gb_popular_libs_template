package ru.gb.gb_popular_libs.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryCacheDataSource
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryCacheDataSourceImpl
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryDataSource
import ru.gb.gb_popular_libs.data.repository.datasource.GitHubRepositoryDataSourceImpl
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryImpl
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserCacheDataSource
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserCacheDataSourceImpl
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.GitHubUserDataSourceImpl
import ru.gb.gb_popular_libs.presentation.MainActivity
import ru.gb.gb_popular_libs.presentation.user.UserFragment
import ru.gb.gb_popular_libs.presentation.users.UsersFragment

@Module(includes = [NetworkModule::class, StorageModule::class])
interface UserModule {

    @ContributesAndroidInjector
    fun bindMainFragment(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @Binds
    fun bindGitHubUserRepository(
        gitHubUserRepository: GitHubUserRepositoryImpl
    ): GitHubUserRepository

    @Binds
    fun bindGitHubUserDataSource(
        gitHubUserDataSource: GitHubUserDataSourceImpl
    ): GitHubUserDataSource

    @Binds
    fun bindGitHubUserCacheDataSource(
        gitHubUserCacheDataSource: GitHubUserCacheDataSourceImpl
    ): GitHubUserCacheDataSource

    @Binds
    fun bindGitHubRepositoryDataSource(
        gitHubRepositoryDataSource: GitHubRepositoryDataSourceImpl
    ): GitHubRepositoryDataSource

    @Binds
    fun bindGitHubRepositoryCacheDataSource(
        gitHubRepositoryCacheDataSource: GitHubRepositoryCacheDataSourceImpl
    ): GitHubRepositoryCacheDataSource

}