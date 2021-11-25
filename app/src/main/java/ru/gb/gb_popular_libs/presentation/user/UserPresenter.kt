package ru.gb.gb_popular_libs.presentation.user

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel.Mapper

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            Observable.merge(
                userRepository
                    .getUser(userLogin)
                    .map(Mapper::map)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(viewState::showUser),
                userRepository
                    .getUserRepositories(userLogin)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(viewState::showRepositories)
            )
            .subscribeOn(Schedulers.io())
            .subscribe({}, viewState::showError)
    }

    override fun onDestroy() {
        disposables.clear()
    }

}