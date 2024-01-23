package com.example.kmmplayground.presentation.home

import com.example.kmmplayground.data.remote.ServiceResult

data class HomeState(
    val getNews: ServiceResult = ServiceResult.Empty
)