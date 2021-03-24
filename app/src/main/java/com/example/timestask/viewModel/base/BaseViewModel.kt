package com.example.timestask.viewModel.base

import androidx.lifecycle.ViewModel
import com.example.timestask.callBack.BaseCallBack

open class BaseViewModel<V:BaseCallBack> : ViewModel() , BaseVmodel<V> {
    lateinit var view:V
    override fun attachView(view: V) {
        this.view=view
    }
}