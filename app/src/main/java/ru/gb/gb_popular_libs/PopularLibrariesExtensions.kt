package ru.gb.gb_popular_libs

import android.view.View

fun View.click(click: () -> Unit) = setOnClickListener { click() }