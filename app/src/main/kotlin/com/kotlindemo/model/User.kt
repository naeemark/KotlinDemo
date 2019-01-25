package com.kotlindemo.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

/**
 * A class to contain attributes for User
 *
 * @property email String
 * @property password String
 * @property isDataValid Boolean
 * @constructor
 */
class User(private var email: String, private var password: String) : BaseObservable() {

    val isDataValid: Boolean
        get() = !TextUtils.isEmpty(getEmail())
                && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
                && getPassword().length > 6

    /**
     * Gets Validation code on the base of provided data
     * @return Int
     */
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

    /**
     * Getter
     * @return String
     */
    fun getEmail(): String {

        return email
    }

    /**
     * Setter
     * @param email String
     */
    fun setEmail(email: String) {

        this.email = email
    }

    /**
     * Getter
     * @return String
     */
    fun getPassword(): String {

        return password
    }

    /**
     * Setter
     * @param email String
     */
    fun setPassword(password: String) {

        this.password = password
    }
}