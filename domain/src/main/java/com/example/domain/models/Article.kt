package com.example.domain.models

data class Article(
    val id:Long,
    val title:String?=null,
    val byline:String?=null,
    val abstract:String?=null,
    val source:String?=null,
    val published_date:String?=null,
    val updated:String?=null,
    val section:String?=null,
    val subsection:String?=null,
    val nytdsection:String?=null,
    val adx_keywords:String?=null,
    val media:ArrayList<Media>? =null
){
    val image : String
        get() = try {
        media?.get(0)?.media_metadata?.get(2)?.url ?: ""
    }catch (e:Exception){ "" }
}