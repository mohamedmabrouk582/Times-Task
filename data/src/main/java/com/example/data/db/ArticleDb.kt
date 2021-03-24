package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.entities.ArticleEntity

@Database(entities = [ArticleEntity::class] , version = 1 , exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class ArticleDb : RoomDatabase(){
    abstract fun getDao() : ArticleDao
}