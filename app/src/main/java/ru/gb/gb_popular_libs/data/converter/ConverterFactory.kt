package ru.gb.gb_popular_libs.data.converter

import android.content.Context

object ConverterFactory {

    fun create(context: Context): Converter = ConverterImpl(context)

}