package com.kotlindemo.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kotlindemo.R
import com.kotlindemo.databinding.FragmentOnboardingPrefLanguageBinding
import com.kotlindemo.databinding.InnerBinding
import com.kotlindemo.model.LanguagePreference
import com.kotlindemo.model.User
import com.kotlindemo.model.viewModel.LoginViewModel
import com.kotlindemo.model.viewModel.LoginViewModelFactory
import es.dmoral.toasty.Toasty
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.inner.*
import kotlinx.android.synthetic.main.inner_language_preference_buttons.*

class MainActivity : AppCompatActivity() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    var binding: FragmentOnboardingPrefLanguageBinding? = null
    val langPref: LanguagePreference = LanguagePreference()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.fragment_onboarding_pref_language)

        binding?.lang = langPref


    }


    fun switchSelection(view: View) {

        when (view.tag) {
            "ENGLISH" -> langPref.ENGLISH = !langPref.ENGLISH
            "CHINESE" -> langPref.CHINESE = !langPref.CHINESE
            "BHASA" -> langPref.BHASA = !langPref.BHASA
            "TAMIL" -> langPref.TAMIL = !langPref.TAMIL
        }


        binding?.invalidateAll()

    }


    fun saveLanguageSelection(view:View){

        println(langPref.toString())
    }

//        val viewModel = ViewModelProviders.of(this, LoginViewModelFactory()).get(LoginViewModel::class.java)
//        activityMainBinding.viewModel = viewModel
//
//        val disposable = viewModel.successObservable
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                onSuccess(it)
//            }, {})
//        disposables.add(disposable)
//
//        val disposableFailure = viewModel.failureObservable
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                onError(it)
//            }, {})
//        disposables.add(disposableFailure)
//
//    }
//
//     fun onSuccess(message: String) {
//        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    fun onError(message: String) {
//        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
//    }

}
