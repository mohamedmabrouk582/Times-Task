package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.ArticleDao
import com.example.data.db.ArticleDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    @Singleton
    fun getDB(@ApplicationContext context: Context) :ArticleDb =
        Room.inMemoryDatabaseBuilder(context,ArticleDb::class.java)
            .allowMainThreadQueries().fallbackToDestructiveMigration()
            .build()
}