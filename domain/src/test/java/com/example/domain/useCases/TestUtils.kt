package com.example.domain.useCases

import com.example.domain.models.Article
import com.example.domain.models.ArticleResponse
import com.example.domain.models.Result
import kotlinx.coroutines.flow.flow

object TestUtils {
    val articles = ArrayList(
        (1..5).map {
            Article(it.toLong(),"article$it")
        }
    )

    fun getArticles() = flow {
        emit(Result.OnSuccess(ArticleResponse("ok",articles)))
    }
}