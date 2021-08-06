package ru.gb.gb_popular_libs.data.converter

import android.content.Context
import android.net.Uri
import io.reactivex.Single

class ConverterImpl(private val context: Context) : Converter {

    override fun convert(uri: Uri): Single<Uri> =
        ConverterSingle(context, uri)

}