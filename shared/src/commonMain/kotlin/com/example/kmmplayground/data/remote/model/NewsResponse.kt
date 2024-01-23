package com.example.kmmplayground.data.remote.model

import com.example.kmmplayground.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResult: Int
)