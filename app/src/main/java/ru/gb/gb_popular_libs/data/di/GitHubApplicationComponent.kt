package ru.gb.gb_popular_libs.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.gb.gb_popular_libs.PopularLibraries
import ru.gb.gb_popular_libs.data.di.modules.GitHubApplicationModule
import ru.gb.gb_popular_libs.scheduler.Schedulers

@Component(modules = [AndroidInjectionModule::class, GitHubApplicationModule::class])
interface GitHubApplicationComponent : AndroidInjector<PopularLibraries> {

    fun gitHubUsersComponent(): GitHubUsersComponent.Builder
    fun gitHubUserComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): GitHubApplicationComponent

    }

}