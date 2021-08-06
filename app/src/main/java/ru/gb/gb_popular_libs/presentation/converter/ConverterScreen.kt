package ru.gb.gb_popular_libs.presentation.converter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ConverterScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        ConverterFragment.newInstance()

}