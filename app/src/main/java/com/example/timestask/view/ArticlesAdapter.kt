package com.example.timestask.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.entities.ArticleEntity
import com.example.domain.models.Article
import com.example.timestask.R
import com.example.timestask.databinding.ArticleItemViewBinding

class ArticlesAdapter(val listener:ArticleListener) : RecyclerView.Adapter<ArticlesAdapter.Holder>() {
    var articles:ArrayList<ArticleEntity> = ArrayList()
    set(value) {
        field=value
        notifyDataSetChanged()
    }
    inner class  Holder(private val viewBinding:ArticleItemViewBinding) : RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item:ArticleEntity){
            viewBinding.article=item
            viewBinding.executePendingBindings()
            viewBinding.root.setOnClickListener {
                listener.onArticleCLick(item)
            }
        }
    }

    interface ArticleListener{
        fun onArticleCLick(item:ArticleEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.article_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size
}