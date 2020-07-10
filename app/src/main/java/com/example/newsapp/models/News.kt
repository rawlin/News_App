package com.example.newsapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)