package ru.gb.gb_popular_libs.presentation.user

import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            ?.let(viewState::showUser)
    }

}