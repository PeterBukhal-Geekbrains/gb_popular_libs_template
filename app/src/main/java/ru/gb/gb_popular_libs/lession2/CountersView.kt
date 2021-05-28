package ru.gb.gb_popular_libs.lession2

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

interface CountersView: MvpView {

    /**
     * Показывает приветственное сообщение
     * для пользователя.
     */
    @OneExecution
    fun showOnBoarding()

    /**
     * Показвает значение счетчика 1.
     * @param counter значение
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCounter1(counter: String)

    /**
     * Показвает значение счетчика 2.
     * @param counter значение
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCounter2(counter: String)

    /**
     * Показвает значение счетчика 3.
     * @param counter значение
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCounter3(counter: String)

    /**
     * Показывает сообщение о изменении счетчика.
     */
    @Skip
    fun showCounterMessage()

}