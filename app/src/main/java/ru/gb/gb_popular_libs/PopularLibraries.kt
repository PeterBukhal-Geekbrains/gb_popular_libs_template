package ru.gb.gb_popular_libs

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.gb.gb_popular_libs.di.DaggerPopularLibrariesComponent
import ru.gb.gb_popular_libs.presentation.navigation.CustomRouter
import ru.gb.gb_popular_libs.scheduler.SchedulersFactory

class PopularLibraries : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerPopularLibrariesComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(SchedulersFactory.create())
            .apply {
                val cicerone = Cicerone.create(CustomRouter())
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

}