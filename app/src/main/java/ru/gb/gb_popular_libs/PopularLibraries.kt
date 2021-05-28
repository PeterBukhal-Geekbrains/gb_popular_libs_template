package ru.gb.gb_popular_libs

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import ru.gb.gb_popular_libs.presentation.navigation.CustomRouter

class PopularLibraries : Application() {

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }

}