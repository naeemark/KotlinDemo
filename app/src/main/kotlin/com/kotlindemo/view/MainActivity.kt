package com.kotlindemo.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlindemo.R
import com.kotlindemo.databinding.ActivityMainBinding
import com.kotlindemo.model.interfaces.LoginResultCallbacks
import com.kotlindemo.model.viewModel.LoginViewModel
import com.kotlindemo.model.viewModel.LoginViewModelFactory
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

}
