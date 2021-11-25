package ru.gb.gb_popular_libs.presentation.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel.Mapper
import ru.gb.gb_popular_libs.presentation.user.UserScreen
import ru.gb.gb_popular_libs.scheduler.Schedulers

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<UsersView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUsers()
                .observeOn(schedulers.background())
                .map { users -> users.map(Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
    }

    fun displayUser(user: GitHubUserViewModel) {
        router.navigateTo(UserScreen(user.login))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}