package com.kotlindemo.model.viewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.kotlindemo.model.User
import com.kotlindemo.model.interfaces.LoginResultCallbacks

class LoginViewModel(private val listener: LoginResultCallbacks) : ViewModel() {

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
    fun onLoginClicked(v: View) {

        val logs  = String.format("Email: %s(%d), Password: %s(%d)", user.getEmail(), user.getEmail().length, user.getPassword(), user.getPassword().length)

        Log.e("TAG", logs)

        if (user.isDataValid)
            listener.onSuccess("Login Success")
        else
            listener.onError("Login Error")
    }
}
