package ru.gb.gb_popular_libs.lession2

class CountersModel(private val counters: MutableList<Int> = mutableListOf(0, 0, 0)) {

    fun incrementCounter(counterId: Int) = ++counters[counterId]

}