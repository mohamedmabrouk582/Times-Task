package com.example.timestask.di

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
class RoomModule {

    @Provides
    @Singleton
    fun getDao(@ApplicationContext context: Context) : ArticleDao =
        Room.databaseBuilder(context,ArticleDb::class.java,"Article")
            .fallbackToDestructiveMigration().build().getDao()
}