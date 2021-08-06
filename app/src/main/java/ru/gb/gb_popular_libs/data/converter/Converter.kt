package ru.gb.gb_popular_libs.data.converter

import android.net.Uri
import io.reactivex.Single

interface Converter {

    /**
     *
     */
    fun convert(uri: Uri): Single<Uri>

}