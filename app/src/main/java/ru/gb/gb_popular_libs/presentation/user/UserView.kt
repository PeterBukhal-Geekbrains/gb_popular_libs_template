package ru.gb.gb_popular_libs.presentation.user

import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.data.repository.GitHubRepository
import ru.gb.gb_popular_libs.presentation.GitHubUserViewModel
import ru.gb.gb_popular_libs.presentation.ScreenView

interface UserView : ScreenView {

    /**
     * Показывает информацию о пользователе.
     * @param user пользователь
     */
    @SingleState
    fun showUser(user: GitHubUserViewModel)

    /**
     * Показывает информацию о репозиториях пользователе.
     * @param repositories репозитории
     */
    @SingleState
    fun showRepositories(repositories: List<GitHubRepository>)

}