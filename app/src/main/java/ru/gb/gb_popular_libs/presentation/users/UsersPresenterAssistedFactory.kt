package ru.gb.gb_popular_libs.presentation.users

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UsersPresenterAssistedFactory {

    fun create(): UsersPresenter

}