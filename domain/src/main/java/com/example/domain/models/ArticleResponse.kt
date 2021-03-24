package com.example.domain.models

data class ArticleResponse(
    val status:String,
    val results:ArrayList<Article>
)