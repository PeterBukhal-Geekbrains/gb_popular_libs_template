package ru.gb.gb_popular_libs.presentation.converter

import android.net.Uri
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.gb.gb_popular_libs.presentation.ScreenView

interface ConverterView : ScreenView {

    @AddToEndSingle
    fun showContent(uri: Uri?)

    @AddToEndSingle
    fun showLoading()

}