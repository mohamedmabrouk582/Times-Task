package com.example.timestask.view.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.data.entities.ArticleEntity
import com.example.timestask.R
import com.example.timestask.databinding.ArticleDetailsFargmentBinding
import com.example.timestask.utils.ARTICLE_KEY
import com.example.timestask.view.activities.MainActivity

class ArticleDetailsFragment  : Fragment(R.layout.article_details_fargment) {
    lateinit var viewBinding : ArticleDetailsFargmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar?.hide()
        DataBindingUtil.bind<ArticleDetailsFargmentBinding>(view)?.let {
            viewBinding=it
        }
        arguments?.getParcelable<ArticleEntity>(ARTICLE_KEY)?.let {
            viewBinding.articleDetails=it
        }
        viewBinding.backImg.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}