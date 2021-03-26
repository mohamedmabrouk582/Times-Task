package com.example.domain.useCases

import com.example.domain.models.Article
import com.example.domain.models.ArticleResponse
import com.example.domain.models.Result
import com.example.domain.repository.ArticleDefaultRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticleRepositoryUseCaseTest{
    private val testDispatcher= TestCoroutineDispatcher()
    private val testScope= TestCoroutineScope()
    private val repository = object : ArticleDefaultRepository{
        override suspend fun getAllArticles(): Flow<Result<ArticleResponse>> {
            return TestUtils.getArticles()
        }

        override suspend fun insertAllArticles(articles: ArrayList<Article>) {
          TestUtils.articles.addAll(articles)
        }
    }

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }


    @Test
    fun `getAllArticles() success()`()= testScope.runBlockingTest {
        val articles = repository.getAllArticles().first()
        assertThat(articles).isEqualTo(Result.OnSuccess(ArticleResponse("ok",TestUtils.articles)))
    }

    @Test
    fun `InsertAllArticles() success()`()=testScope.runBlockingTest {
        val articles= arrayListOf(Article(6,"item6"),Article(7,"item7"))
        repository.insertAllArticles(articles)
        assertThat(TestUtils.articles).containsAnyOf(Article(6,"item6"),Article(7,"item7"))
    }

}