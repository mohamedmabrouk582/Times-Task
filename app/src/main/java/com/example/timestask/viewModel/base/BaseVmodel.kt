package com.example.timestask.viewModel.base

import com.example.timestask.callBack.BaseCallBack

interface BaseVmodel<V:BaseCallBack> {
    fun attachView(view:V)
}