package ru.gb.gb_popular_libs.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.gb.gb_popular_libs.PopularLibraries
import ru.gb.gb_popular_libs.presentation.navigation.CustomRouter
import ru.gb.gb_popular_libs.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, UserModule::class])
interface PopularLibrariesComponent : AndroidInjector<PopularLibraries> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        @BindsInstance
        fun withRouter(router: CustomRouter): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): PopularLibrariesComponent

    }

}