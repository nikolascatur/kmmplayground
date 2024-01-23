package com.example.kmmplayground.di

import com.example.kmmplayground.data.local.AppPreferencesRepository
import com.example.kmmplayground.data.local.dataStoreFileName
import com.example.kmmplayground.data.local.getDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal actual fun getDatastoreModuleByPlatform() = module {

    single {
        getDataStore {
            androidContext().filesDir?.resolve(dataStoreFileName)?.absolutePath
                ?: throw Exception("Couldn't get Android Datastore context.")
        }
    }

    single { AppPreferencesRepository(get()) }
}