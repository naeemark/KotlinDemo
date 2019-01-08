package com.kotlindemo.model.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kotlindemo.model.interfaces.LoginResultCallbacks

class LoginViewModelFactory(private val listener: LoginResultCallbacks) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}