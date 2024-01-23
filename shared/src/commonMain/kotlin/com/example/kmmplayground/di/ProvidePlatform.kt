package com.example.kmmplayground.di

import kotlinx.coroutines.CoroutineDispatcher


interface Dispatchers {
    val io: CoroutineDispatcher
}

internal expect fun provideProvider(): Dispatchers