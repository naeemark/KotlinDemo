package com.kotlindemo.model

import android.view.View


class LanguagePreference() {

    var ENGLISH = true
    var CHINESE = false
    var BHASA = false
    var TAMIL = false

    fun isValidSelection(): Boolean = (!ENGLISH and !CHINESE and !BHASA and !TAMIL).not()

    override fun toString(): String =
        "LanguagePreference(ENGLISH=$ENGLISH, CHINESE=$CHINESE, BHASA=$BHASA, TAMIL=$TAMIL)"


}


