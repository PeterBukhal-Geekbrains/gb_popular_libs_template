package ru.gb.gb_popular_libs.presentation.converter

import android.net.Uri
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.data.converter.Converter
import ru.gb.gb_popular_libs.scheduler.Schedulers

class ConverterPresenter(
    private val converter: Converter,
    private val schedulers: Schedulers
) : MvpPresenter<ConverterView>() {

    private val disposables = CompositeDisposable()

    fun convert(uri: Uri) {
        viewState.showContent(uri)
        viewState.showLoading()

        disposables +=
            converter
                .convert(uri)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showContent,
                    viewState::showError
                )
    }

    fun cancel() {
        viewState.showContent(null)
        disposables.clear()
    }

    override fun onDestroy() = disposables.clear()

}