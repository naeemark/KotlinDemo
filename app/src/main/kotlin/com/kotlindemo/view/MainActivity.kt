package com.kotlindemo.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlindemo.R
import com.kotlindemo.databinding.ActivityMainBinding
import com.kotlindemo.model.viewModel.LoginViewModel
import com.kotlindemo.model.viewModel.LoginViewModelFactory
import es.dmoral.toasty.Toasty
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, LoginViewModelFactory()).get(LoginViewModel::class.java)
        activityMainBinding.viewModel = viewModel

        val disposable = viewModel.successObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                onSuccess(it)
            }, {})
        disposables.add(disposable)

        val disposableFailure = viewModel.failureObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                onError(it)
            }, {})
        disposables.add(disposableFailure)

    }

     fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

}
