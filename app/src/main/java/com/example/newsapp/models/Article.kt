package com.example.newsapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Article(
    val author: String?="-",
    val content: String?=null,
    val description: String?="-",
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?=null
):Serializable