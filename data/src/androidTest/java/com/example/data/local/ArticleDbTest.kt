package com.example.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.data.MainCoroutinesRule
import com.example.data.TestUtils
import com.example.data.db.ArticleDao
import com.example.data.db.ArticleDb
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class ArticleDbTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutinesRule = MainCoroutinesRule()
    lateinit var articleDao: ArticleDao
    @Inject lateinit var db:ArticleDb

    @Before
    fun setup(){
        hiltRule.inject()
        articleDao=db.getDao()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun insertAllArticles()=mainCoroutinesRule.runBlockingTest{
        articleDao.insertArticles(TestUtils.articles)
        val first = articleDao.getArticles().first()
        assertThat(first).isEqualTo(TestUtils.articles)
    }
}