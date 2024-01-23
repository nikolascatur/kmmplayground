package com.example.kmmplayground.data.repository

import com.example.kmmplayground.data.local.AppPreferences
import com.example.kmmplayground.data.local.AppPreferencesRepository
import com.example.kmmplayground.data.remote.NewsService
import com.example.kmmplayground.data.remote.ServiceResult
import com.example.kmmplayground.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    val appPreferences: AppPreferencesRepository,
    val service: NewsService
) :
    NewsRepository {
    override suspend fun saveAppEntry(isAlreadyOnboarding: Boolean) =
        appPreferences.saveAppEntry(isAlreadyOnboarding)

    override suspend fun isAlreadyOnboarding(): Flow<AppPreferences> =
        appPreferences.userPreferencesFlow

    override suspend fun getNews(sources: String, page: Int): ServiceResult =
        service.getNews(sources, page)

    override suspend fun getNewsSearch(search: String, sources: String, page: Int): ServiceResult =
        service.getNewsSearch(search, sources, page)
}