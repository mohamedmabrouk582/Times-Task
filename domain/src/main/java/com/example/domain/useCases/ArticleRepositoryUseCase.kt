package com.example.domain.useCases

import com.example.domain.models.ArticleResponse
import com.example.domain.models.Result
import com.example.domain.repository.ArticleDefaultRepository
import kotlinx.coroutines.flow.Flow

class ArticleRepositoryUseCase (val repository:ArticleDefaultRepository) {
    suspend fun getAllArticles(): Flow<Result<ArticleResponse>>{
        return repository.getAllArticles()
    }
}