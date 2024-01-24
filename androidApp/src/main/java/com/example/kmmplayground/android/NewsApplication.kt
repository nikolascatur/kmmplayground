package com.example.kmmplayground.android

import android.app.Application
import com.example.kmmplayground.di.initKoin
import org.koin.android.ext.koin.androidContext

class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@NewsApplication)
        }
    }
}