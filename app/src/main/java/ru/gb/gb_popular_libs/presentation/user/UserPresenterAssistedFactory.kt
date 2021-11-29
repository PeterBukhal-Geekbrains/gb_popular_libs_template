package ru.gb.gb_popular_libs.presentation.user

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface UserPresenterAssistedFactory {

    fun create(@Assisted("login") userLogin: String): UserPresenter

}