package com.example.kmmplayground.di

import com.example.kmmplayground.presentation.detail.DetailViewModel
import com.example.kmmplayground.presentation.home.HomeViewModel
import com.example.kmmplayground.presentation.main.MainViewModel
import org.koin.dsl.module

internal actual fun getViewModelByPlatform() = module {
    single { MainViewModel(get(), provideProvider()) }
    single { HomeViewModel(get(), provideProvider()) }
    single { DetailViewModel(get(), provideProvider()) }
}