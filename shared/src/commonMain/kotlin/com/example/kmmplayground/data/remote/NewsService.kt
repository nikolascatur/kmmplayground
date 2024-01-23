package com.example.kmmplayground.data.remote

import co.touchlab.kermit.Logger
import co.touchlab.kermit.NoTagFormatter
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter
import com.example.kmmplayground.data.remote.ApiConstant.EVERYTHING
import com.example.kmmplayground.data.remote.model.NewsResponse
import com.example.kmmplayground.util.Constant.API_KEY
import com.example.kmmplayground.util.Constant.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsService(private val client: HttpClient) {

    private val storeLogger = Logger(
        loggerConfigInit(platformLogWriter(NoTagFormatter)),
        "StoreApi"
    )

    suspend fun getNews(
        sources: String, page: Int, apiKey: String = API_KEY
    ): ServiceResult {
        return try {
            val news: NewsResponse = client.get(BASE_URL + EVERYTHING) {
                url {
                    parameters.append(ApiConstant.Param.SOURCES, sources)
                    parameters.append(ApiConstant.Param.PAGE, page.toString())
                    parameters.append(ApiConstant.Param.API_KEY, apiKey)
                }
            }.body()
            ServiceResult.Success(news)
        } catch (error: Exception) {
            storeLogger.d { error.message.toString() }
            ServiceResult.Error("", error.message ?: "API ERROR")
        }
    }

    suspend fun getNewsSearch(
        search: String,
        sources: String,
        page: Int,
        apiKey: String = API_KEY
    ): ServiceResult {
        return try {
            val news: NewsResponse = client.get(BASE_URL + EVERYTHING) {
                url {
                    parameters.append(ApiConstant.Param.Q, search)
                    parameters.append(ApiConstant.Param.SOURCES, sources)
                    parameters.append(ApiConstant.Param.PAGE, page.toString())
                    parameters.append(ApiConstant.Param.API_KEY, apiKey)
                }
            }.body()
            ServiceResult.Success(news)
        } catch (error: Exception) {
            storeLogger.d { error.message.toString() }
            ServiceResult.Error("", error.message ?: "API ERROR")
        }
    }

}