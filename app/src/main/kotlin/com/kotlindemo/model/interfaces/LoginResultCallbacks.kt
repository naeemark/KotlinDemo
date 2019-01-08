package com.kotlindemo.model.interfaces

interface LoginResultCallbacks {

    fun onSuccess(message: String)
    fun onError(message: String)
}