package ru.gb.gb_popular_libs.data.di

import dagger.Subcomponent
import ru.gb.gb_popular_libs.data.di.modules.GitHubUserModule
import ru.gb.gb_popular_libs.presentation.user.UserFragment

@GitHubUser
@Subcomponent(modules = [GitHubUserModule::class])
interface GitHubUserComponent {

    fun inject(userFragment: UserFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): GitHubUserComponent

    }

}