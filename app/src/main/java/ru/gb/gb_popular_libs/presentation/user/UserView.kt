package ru.gb.gb_popular_libs.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface UserView : MvpView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showUser(user: GitHubUser)

}