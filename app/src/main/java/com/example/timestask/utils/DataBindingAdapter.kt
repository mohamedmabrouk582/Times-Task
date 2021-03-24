package com.example.timestask.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.timestask.R

class DataBindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("app:LoadImage")
        fun loadImage(view: AppCompatImageView,url:String?){
            Glide.with(view.context)
                .load(url?:"")
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(view)
        }
    }
}