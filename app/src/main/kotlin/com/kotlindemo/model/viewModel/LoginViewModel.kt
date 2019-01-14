package com.kotlindemo.model.viewModel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.kotlindemo.model.User
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class LoginViewModel: ViewModel() {

    val success: ObservableField<String> = ObservableField<String>()
    val failure: ObservableField<String> = ObservableField<String>()
    private val successSubject: PublishSubject<String> = PublishSubject.create()
    val successObservable: Observable<String>
        get() = successSubject

    private val failureSubject: PublishSubject<String> = PublishSubject.create()
    val failureObservable: Observable<String>
        get() = failureSubject


    private val user: User

    init {
        this.user = User("", "")
    }

    // get Email after user enters text
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

    // get Password after user enters text
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

    // create function to process Login button Clicked
    @SuppressWarnings
    fun onLoginClicked(v: View) {

        val logs: String = String.format(
            "Email: %s(%d), Password: %s(%d)",
            user.getEmail(),
            user.getEmail().length,
            user.getPassword(),
            user.getPassword().length
        )
        Log.e("TAG", logs)

        val validationCode: Int = user.getValidationCode()

        when (validationCode) {
            -1 -> {
                success.set("Login Successfull")
                successSubject.onNext("Login Successfull")
            } //listener.onSuccess("Login Successful")
            0 -> {
                failure.set("Email not provided")
                failureSubject.onNext("Email not provided")
            }
            1 -> {
                failure.set("Wrong Email Pattern")
                failureSubject.onNext("Wrong Email Pattern")
            }
            2 -> {
                failure.set("Invalid Password Length")
                failureSubject.onNext("Invalid Password Length")
            }
        }
    }
}
