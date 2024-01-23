package com.example.kmmplayground.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import co.touchlab.kermit.Logger
import com.example.kmmplayground.data.local.DataStoreConstant.APP_ENTRY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent

data class AppPreferences(
    val AppEntry: Boolean
)

class AppPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) : KoinComponent {

    private val logger = Logger.withTag("UserPreferencesManager")

    val userPreferencesFlow: Flow<AppPreferences> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                logger.d { "Error reading preferences: $exception" }
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            mapAppPreferences(preferences)
        }

    suspend fun saveAppEntry(isOnboarding: Boolean) {
        dataStore.edit { preferences ->
            preferences[APP_ENTRY] = isOnboarding
        }
    }

    private fun mapAppPreferences(preferences: Preferences): AppPreferences {
        val lastScreen = preferences[APP_ENTRY] ?: false
        return AppPreferences(lastScreen)
    }
}