package com.example.kmmplayground.di

import com.example.kmmplayground.data.local.AppPreferencesRepository
import com.example.kmmplayground.data.local.dataStoreFileName
import com.example.kmmplayground.data.local.getDataStore
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

internal actual fun getDatastoreModuleByPlatform() = module {
    single {
        getDataStore {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null
            )
            requireNotNull(documentDirectory).path + "/$dataStoreFileName"
        }
    }

    single { AppPreferencesRepository(get()) }

}