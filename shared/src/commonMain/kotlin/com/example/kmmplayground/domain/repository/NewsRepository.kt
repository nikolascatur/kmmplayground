package com.example.kmmplayground.domain.repository

import com.example.kmmplayground.data.local.AppPreferences
import com.example.kmmplayground.data.remote.ServiceResult
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun saveAppEntry(isAlreadyOnboarding: Boolean)
    suspend fun isAlreadyOnboarding(): Flow<AppPreferences>
    suspend fun getNews(sources: String, page: Int): ServiceResult
    suspend fun getNewsSearch(search: String,sources: String, page: Int): ServiceResult
}