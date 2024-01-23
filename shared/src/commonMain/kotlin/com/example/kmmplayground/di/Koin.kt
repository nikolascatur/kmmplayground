package com.example.kmmplayground.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(CommonModule, getDatastoreModuleByPlatform(), getViewModelByPlatform())
}