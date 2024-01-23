package com.example.kmmplayground.di

import kotlinx.coroutines.CoroutineDispatcher

actual fun provideProvider(): Dispatchers = object : Dispatchers {
    override val io: CoroutineDispatcher
        get() = kotlinx.coroutines.Dispatchers.IO

}