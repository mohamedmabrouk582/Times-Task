package com.example.data.api

import com.example.data.BuildConfig
import com.example.domain.models.ArticleResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ArticleApi {
 @GET("viewed/7.json?api-key=${BuildConfig.API_KEY}")
 suspend fun getArticlesAsync() : Response<ArticleResponse>
}