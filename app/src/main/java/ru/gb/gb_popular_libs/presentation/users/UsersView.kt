package ru.gb.gb_popular_libs.presentation.users

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.data.user.GitHubUser

interface UsersView : MvpView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUser>)

}