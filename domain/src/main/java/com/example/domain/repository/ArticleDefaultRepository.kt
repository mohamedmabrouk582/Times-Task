package com.example.domain.repository

import com.example.domain.models.Article
import com.example.domain.models.ArticleResponse
import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface ArticleDefaultRepository {
    suspend fun getAllArticles() : Flow<Result<ArticleResponse>>
    suspend fun insertAllArticles(articles:ArrayList<Article>)
}