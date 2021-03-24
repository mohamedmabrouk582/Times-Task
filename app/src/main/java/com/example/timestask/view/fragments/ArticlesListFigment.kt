package com.example.timestask.view.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.data.entities.ArticleEntity
import com.example.domain.models.Article
import com.example.timestask.R
import com.example.timestask.callBack.ArticlesCallBack
import com.example.timestask.databinding.ArticleListFargmentBinding
import com.example.timestask.utils.ARTICLE_KEY
import com.example.timestask.view.ArticlesAdapter
import com.example.timestask.view.activities.MainActivity
import com.example.timestask.viewModel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ArticlesListFigment : Fragment(R.layout.article_list_fargment)  ,
    ArticlesAdapter.ArticleListener {
    lateinit var viewBinding : ArticleListFargmentBinding
    private val viewModel : ArticleViewModel by viewModels()
    private val mAdapter by lazy { ArticlesAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<ArticleListFargmentBinding>(view)?.let { viewBinding=it }
        //viewModel.attachView(this)
        (activity as MainActivity).supportActionBar?.show()
        viewBinding.vm=viewModel
        viewBinding.articleRcv.adapter=mAdapter
        viewModel.getAllArticle()
        lifecycleScope.launchWhenStarted {
            viewModel.articles.collect {
                mAdapter.articles=it
            }
        }
    }

    override fun onArticleCLick(item: ArticleEntity) {
       val bundle = Bundle()
        bundle.putParcelable(ARTICLE_KEY,item)
        (activity as MainActivity).navController.navigate(R.id.action_articlesListFigment_to_articleDetailsFragment,bundle)
    }




}