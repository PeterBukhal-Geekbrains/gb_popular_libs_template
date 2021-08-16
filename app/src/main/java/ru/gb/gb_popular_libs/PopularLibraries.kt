package ru.gb.gb_popular_libs

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import ru.gb.gb_popular_libs.data.di.DaggerApplicationComponent
import ru.gb.gb_popular_libs.scheduler.DefaultSchedulers

class PopularLibraries : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<PopularLibraries> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {  }
    }

}