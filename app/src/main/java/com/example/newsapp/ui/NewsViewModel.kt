package com.example.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.News
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {

    val topNews:MutableLiveData<Resource<News>> = MutableLiveData()

    init {
        getTopNews("in")
    }

    fun getTopNews(countryCode:String)=viewModelScope.launch {
        topNews.postValue(Resource.Loading())
        val response=newsRepository.getTopNews(countryCode)
        topNews.postValue(handleTopNewsresponse(response))

    }

    private fun handleTopNewsresponse(response: Response<News>):Resource<News>{
        if (response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }

}