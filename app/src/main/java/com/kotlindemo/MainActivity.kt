package com.kotlindemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startRStream(view: View) {

        // create an Observable
        val myObservable = getObservable()
        
        // create an Observer
        val myObserver = getObserver()


        // subscribe myObservable to myObserver
        myObservable.subscribe(myObserver)
    }

    private fun getObservable(): Observable<String> {

        Log.d(TAG, "getObservable: ")
        return Observable.just("1", "2", "3", "4", "5")
    }


    private fun getObserver(): Observer<String> {

        return object : Observer<String>{

            override fun onSubscribe(d: Disposable) {

                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: String) {
                Log.d(TAG, "onNext: $t")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: $e")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        }
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }
}
