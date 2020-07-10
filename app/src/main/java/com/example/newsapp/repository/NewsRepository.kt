package com.example.newsapp.repository

import com.example.newsapp.RetrofitInstance

class NewsRepository {

    suspend fun getTopNews(countryCode:String)=
        RetrofitInstance.api.getNews(countryCode)
}