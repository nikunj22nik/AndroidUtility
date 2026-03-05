package com.example.utility

import android.util.Log

object Logger {

    private const val DEFAULT_TAG = "UtilsSDK"

    fun d(message: String, tag: String = DEFAULT_TAG) {
        Log.d(tag, message)
    }

    fun e(message: String, tag: String = DEFAULT_TAG) {
        Log.e(tag, message)
    }

}