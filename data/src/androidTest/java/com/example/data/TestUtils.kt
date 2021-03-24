package com.example.data

import com.example.data.entities.ArticleEntity
import kotlinx.coroutines.flow.flow

object TestUtils {
    val articles = ArrayList(
        (1..2).map { ArticleEntity(it.toLong(),"item$it") }
    )

    fun getArticles() = flow {
        emit(articles)
    }
}