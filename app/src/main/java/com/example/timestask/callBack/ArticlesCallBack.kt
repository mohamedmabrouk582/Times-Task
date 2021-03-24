package com.example.timestask.callBack

import com.example.domain.models.Article

interface ArticlesCallBack: BaseCallBack {
    fun loadAllArticle(articles:ArrayList<Article>)
}