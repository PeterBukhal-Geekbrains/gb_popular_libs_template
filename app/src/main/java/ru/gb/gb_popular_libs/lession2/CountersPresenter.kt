package ru.gb.gb_popular_libs.lession2

import moxy.MvpPresenter

class CountersPresenter(private val model: CountersModel): MvpPresenter<CountersView>() {

    override fun onFirstViewAttach() {
        /*
         * Задаем начальное состояние счетчиков
         * при первом открытии экрана.
         */
        viewState.showCounter1(CountersMapper.map(0))
        viewState.showCounter2(CountersMapper.map(0))
        viewState.showCounter3(CountersMapper.map(0))

        /*
         *
         */
        viewState.showOnBoarding()
    }

    fun incrementCounter1() =
        model.incrementCounter(counterId = 0)
            .let(CountersMapper::map)
            .let(viewState::showCounter1)
            .also { viewState.showCounterMessage() }

    fun incrementCounter2() =
        model.incrementCounter(counterId = 1)
            .let(CountersMapper::map)
            .let(viewState::showCounter2)
            .also { viewState.showCounterMessage() }

    fun incrementCounter3() =
        model.incrementCounter(counterId = 2)
            .let(CountersMapper::map)
            .let(viewState::showCounter3)
            .also { viewState.showCounterMessage() }

}