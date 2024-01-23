package com.example.kmmplayground.data.remote

sealed interface ServiceResult {
    object Loading : ServiceResult
    object Empty : ServiceResult
    data class Success<out T>(val data: T) : ServiceResult
    data class Error(val code: String, val message: String) : ServiceResult
}