package ru.gb.gb_popular_libs.data.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.data.user.GitHubUserRepositoryImpl
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.CacheUserDataSourceImpl
import ru.gb.gb_popular_libs.data.user.datasource.CloudUserDataSource
import ru.gb.gb_popular_libs.data.user.datasource.UserDataSource
import ru.gb.gb_popular_libs.presentation.MainActivity
import ru.gb.gb_popular_libs.presentation.user.UserFragment
import ru.gb.gb_popular_libs.presentation.users.UsersFragment
import javax.inject.Singleton

@Module
interface GitHubUsersModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @Singleton
    @Binds
    fun bindGitHubUserRepository(repository: GitHubUserRepositoryImpl): GitHubUserRepository

    @Singleton
    @Binds
    fun bindUserDataSource(dataSource: CloudUserDataSource): UserDataSource

    @Singleton
    @Binds
    fun bindCacheUserDataSource(dataSource: CacheUserDataSourceImpl): CacheUserDataSource

}