package com.kotlindemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startRStream(view: View) {

        val list = listOf("1", "2", "3", "4", "5")

        val observable = list.toObservable()
        observable.subscribeBy(
            onNext = { println(it)},
            onError = {it.printStackTrace()},
            onComplete = { println("onComplete")}
        ).dispose()
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }
}
