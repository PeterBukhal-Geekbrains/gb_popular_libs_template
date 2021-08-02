package ru.gb.gb_popular_libs.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.navigatorHolder
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.router
import ru.gb.gb_popular_libs.presentation.users.UsersScreen

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(UsersScreen)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}