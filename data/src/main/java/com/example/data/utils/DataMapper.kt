package com.example.data.utils

import com.example.data.entities.ArticleEntity
import com.example.data.entities.MediaEntity
import com.example.data.entities.MediaMetaDataEntity
import com.example.domain.models.Article
import com.example.domain.models.Media
import com.example.domain.models.MediaMetaData

fun MediaMetaData.toEntity() : MediaMetaDataEntity =
        MediaMetaDataEntity(url)
@JvmName("toEntityMediaMetaData")
fun ArrayList<MediaMetaData>.toEntity() :ArrayList<MediaMetaDataEntity> =
    ArrayList(map { it.toEntity() })
fun Media.toEntity() : MediaEntity =
    MediaEntity(media_metadata.toEntity())

@JvmName("toEntityMedia")
fun ArrayList<Media>.toEntity() :ArrayList<MediaEntity> =
        ArrayList(map { it.toEntity() })
fun Article.toEntity() :  ArticleEntity =
    ArticleEntity(id, title, byline, abstract, source, published_date, updated, section, subsection, nytdsection, adx_keywords,media?.toEntity())

fun ArrayList<Article>.toEntity() : ArrayList<ArticleEntity> =
    ArrayList(map { it.toEntity() })