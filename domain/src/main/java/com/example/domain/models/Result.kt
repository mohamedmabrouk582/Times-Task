package com.example.domain.models

sealed class Result<out T:Any>{
    object Loading : Result<Nothing>()
    data class OnSuccess<out T:Any>(val data:T) : Result<T>()
    data class OnFail(val error:String) : Result<Nothing>()
    data class NoInternetConnection(val error:String) : Result<Nothing>()
}
