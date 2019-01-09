package com.kotlindemo.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User(private var email: String, private var password: String) : BaseObservable() {

    val isDataValid: Boolean
        get() = !TextUtils.isEmpty(getEmail())
                && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getPassword().length > 6

    fun getValidationCode(): Int {
        if (TextUtils.isEmpty(getEmail()))
            return 0 // Email not provided
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1 // Wrong Email Pattern
        else if (getPassword().length < 7)
            return 2 // Invalid Password Length
        else
            return -1
    }

    fun getEmail(): String {

        return email
    }

    fun setEmail(email: String) {

        this.email = email
    }

    fun getPassword(): String {

        return password
    }

    fun setPassword(password: String) {

        this.password = password
    }
}