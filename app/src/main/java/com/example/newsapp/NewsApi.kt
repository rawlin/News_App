package com.example.newsapp

import com.example.newsapp.models.News
import com.example.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=e93cc346ff3440de8033f7b5fc8e0b94
interface NewsApi {

    @GET(value = "v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String="in",
        @Query("apiKey")
        apiKey:String=API_KEY

    ):Response<News>
}