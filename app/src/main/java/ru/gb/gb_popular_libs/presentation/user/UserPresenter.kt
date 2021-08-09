package ru.gb.gb_popular_libs.presentation.user

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel.Mapper
import ru.gb.gb_popular_libs.scheduler.Schedulers

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserByLogin(userLogin)
                .map(Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }

}