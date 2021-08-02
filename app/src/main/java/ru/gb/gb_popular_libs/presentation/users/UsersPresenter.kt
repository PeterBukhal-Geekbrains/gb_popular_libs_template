package ru.gb.gb_popular_libs.presentation.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.user.GitHubUser
import ru.gb.gb_popular_libs.data.user.GitHubUserRepository
import ru.gb.gb_popular_libs.presentation.user.UserScreen

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}