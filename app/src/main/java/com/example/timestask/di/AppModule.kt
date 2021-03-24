package com.example.timestask.di

import com.example.data.repository.ArticleRepository
import com.example.domain.repository.ArticleDefaultRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {


    @Binds
    @Singleton
    abstract fun getArticleRepository(repository : ArticleRepository) : ArticleDefaultRepository


}