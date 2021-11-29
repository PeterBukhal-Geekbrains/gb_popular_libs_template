package ru.gb.gb_popular_libs.presentation.user

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel.Mapper
import ru.gb.gb_popular_libs.scheduler.Schedulers

class UserPresenter
@AssistedInject constructor(
    @Assisted("login") private val userLogin1: String,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            Observable.merge(
                userRepository
                    .getUser(userLogin1)
                    .map(Mapper::map)
                    .observeOn(schedulers.main())
                    .doOnNext(viewState::showUser),
                userRepository
                    .getUserRepositories(userLogin1)
                    .observeOn(schedulers.main())
                    .doOnNext(viewState::showRepositories)
            )
            .subscribeOn(schedulers.background())
            .subscribe({}, viewState::showError)
    }

    override fun onDestroy() {
        disposables.clear()
    }

}