package ru.gb.gb_popular_libs.presentation

import android.os.Bundle
import android.widget.Toast
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpAppCompatActivity
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.navigatorHolder
import ru.gb.gb_popular_libs.PopularLibraries.Navigation.router
import ru.gb.gb_popular_libs.data.network.NetworkState
import ru.gb.gb_popular_libs.data.network.NetworkStateObservable
import ru.gb.gb_popular_libs.presentation.users.UsersScreen
import java.util.concurrent.TimeUnit

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(UsersScreen)

        val connect =
            NetworkStateObservable(this)
                .doOnNext { onNext(0, it) }
                .publish()

        connect.connect()

        disposables +=
            connect.delay(32L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe { onNext(1, it) }
        disposables += connect.delay(16L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(2, it) }
        disposables += connect.delay(8L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(3, it) }
    }

    private fun onNext(no: Int, state: NetworkState) {
        Toast.makeText(this, "$no: NetworkState: $state", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()

        disposables.dispose()
    }

}