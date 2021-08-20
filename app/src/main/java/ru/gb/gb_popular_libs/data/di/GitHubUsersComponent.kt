package ru.gb.gb_popular_libs.data.di

import dagger.Subcomponent
import ru.gb.gb_popular_libs.data.di.modules.GitHubUsersModule
import ru.gb.gb_popular_libs.presentation.users.UsersFragment

@GitHubUsers
@Subcomponent(modules = [GitHubUsersModule::class])
interface GitHubUsersComponent {

    fun inject(usersFragment: UsersFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): GitHubUsersComponent

    }

}