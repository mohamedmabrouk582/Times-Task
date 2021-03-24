package com.example.data.repository

import android.content.Context
import com.example.data.api.ArticleApi
import com.example.data.utils.executeCall
import com.example.domain.models.ArticleResponse
import com.example.domain.models.Result
import com.example.domain.repository.ArticleDefaultRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepository @Inject constructor(@ApplicationContext val context: Context , val api:ArticleApi) : ArticleDefaultRepository  {
    override suspend fun getAllArticles(): Flow<Result<ArticleResponse>> {
        return executeCall(context){api.getArticlesAsync()}
    }
}