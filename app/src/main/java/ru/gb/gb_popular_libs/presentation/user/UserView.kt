package ru.gb.gb_popular_libs.presentation.user

import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.presentation.ScreenView

interface UserView : ScreenView {

    /**
     * Показывает информацию о пользователе.
     * @param userModel пользователь
     */
    @SingleState
    fun showUser(userModel: GitHubUserViewModel)

}