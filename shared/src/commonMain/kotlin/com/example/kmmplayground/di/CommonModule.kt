package com.example.kmmplayground.di

import com.example.kmmplayground.data.remote.NewsService
import com.example.kmmplayground.data.repository.NewsRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val CommonModule = module {

    single {
        val client = HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.d(tag = "HTTP_CLIENT", messageString = message)
                    }
                }
                level = LogLevel.ALL
            }
        }
        client
    }

    single { NewsService(get()) }
    single { NewsRepositoryImpl(get(), get()) }


}