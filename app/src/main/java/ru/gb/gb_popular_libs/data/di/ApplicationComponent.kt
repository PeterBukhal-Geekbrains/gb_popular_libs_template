package ru.gb.gb_popular_libs.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.gb.gb_popular_libs.PopularLibraries
import ru.gb.gb_popular_libs.data.di.modules.GitHubApiModule
import ru.gb.gb_popular_libs.data.di.modules.GitHubStorageModule
import ru.gb.gb_popular_libs.data.di.modules.GitHubUsersModule
import ru.gb.gb_popular_libs.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, GitHubUsersModule::class, GitHubApiModule::class, GitHubStorageModule::class])
interface ApplicationComponent : AndroidInjector<PopularLibraries> {

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

        fun build(): ApplicationComponent

    }

}