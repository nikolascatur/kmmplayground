package com.example.kmmplayground.presentation.detail

import com.example.kmmplayground.data.remote.ServiceResult

data class DetailState(
    val getNews: ServiceResult = ServiceResult.Empty
)