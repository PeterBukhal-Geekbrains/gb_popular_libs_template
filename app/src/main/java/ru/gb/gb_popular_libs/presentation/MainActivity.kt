package ru.gb.gb_popular_libs.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpAppCompatActivity
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.navigatorHolder
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.router
import ru.gb.gb_popular_libs.presentation.navigation.CustomNavigator
import ru.gb.gb_popular_libs.data.network.NetworkState
import ru.gb.gb_popular_libs.data.network.NetworkStateObservable
import ru.gb.gb_popular_libs.presentation.users.UsersScreen
import java.util.concurrent.TimeUnit

class MainActivity : MvpAppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        router.openDeepLink(intent?.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            router.newRootScreen(UsersScreen)
            router.openDeepLink(intent?.data)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}