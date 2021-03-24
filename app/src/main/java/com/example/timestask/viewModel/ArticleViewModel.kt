package com.example.timestask.viewModel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.entities.ArticleEntity
import com.example.data.utils.toEntity
import com.example.domain.models.Article
import com.example.domain.models.Result
import com.example.domain.repository.ArticleDefaultRepository
import com.example.timestask.callBack.ArticlesCallBack
import com.example.timestask.viewModel.base.BaseViewModel
import com.mabrouk.loaderlib.RetryCallBack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: ArticleDefaultRepository) : ViewModel() {
    val loader:ObservableBoolean= ObservableBoolean()
    val loaderError:ObservableField<String> = ObservableField()
    val callBack = object : RetryCallBack{
        override fun onRetry() {
            getAllArticle()
        }
    }
    private val _articles = MutableStateFlow<ArrayList<ArticleEntity>>(ArrayList())
    val articles : StateFlow<ArrayList<ArticleEntity>> = _articles

    fun getAllArticle(){
        viewModelScope.launch {
            repository.getAllArticles().collect {
                when(it){
                    Result.Loading -> loader.set(true)
                    is Result.OnFail -> {
                        loader.set(false)
                        loaderError.set(it.error)
                    }
                    is Result.OnSuccess -> {
                        loader.set(false)
                        _articles.value=it.data.results.toEntity()
                    }
                    is Result.NoInternetConnection ->{
                        loader.set(false)

                    }
                    else -> {
                        loader.set(false)
                        loaderError.set(null)
                    }
                }
            }
        }
    }
}