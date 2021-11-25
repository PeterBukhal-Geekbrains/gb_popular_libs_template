package ru.gb.gb_popular_libs.presentation

import android.content.Intent
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.android.support.DaggerAppCompatActivity
import ru.gb.gb_popular_libs.presentation.abs.AbsActivity
import ru.gb.gb_popular_libs.presentation.navigation.CustomNavigator
import ru.gb.gb_popular_libs.presentation.navigation.CustomRouter
import ru.gb.gb_popular_libs.presentation.users.UsersScreen
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = CustomNavigator(activity = this, android.R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

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