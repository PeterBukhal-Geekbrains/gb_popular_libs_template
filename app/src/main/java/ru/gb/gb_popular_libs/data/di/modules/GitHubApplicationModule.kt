package ru.gb.gb_popular_libs.data.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gb.gb_popular_libs.data.di.GitHubUsersComponent
import ru.gb.gb_popular_libs.presentation.MainActivity

@Module(subcomponents = [GitHubUsersComponent::class])
interface GitHubApplicationModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}