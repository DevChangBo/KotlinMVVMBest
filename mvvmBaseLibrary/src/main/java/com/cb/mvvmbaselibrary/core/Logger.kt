package com.cb.mvvmbaselibrary.core

import android.app.Application
import android.content.Context
import android.util.Log
import com.cb.mvvmbaselibrary.BuildConfig
import com.cb.mvvmbaselibrary.simple.ActivityLifecycleCallbacksAdapter

object Logger {
    private const val defaultTag = "Logger"
    private const val nullStr = "__NULL__"

    @JvmStatic
    private var ISDEBUG:Boolean=false;
    fun init(ISDEBUG:Boolean) {
        this.ISDEBUG=ISDEBUG;
    }
    @JvmStatic
    @JvmOverloads
    fun d(tag: String? = null, msg: String?) {
        if (ISDEBUG) {
            Log.d(tag ?: defaultTag, msg ?: nullStr)
        }
    }

    @JvmStatic
    @JvmOverloads
    fun i(tag: String? = null, msg: String?) {
        if (ISDEBUG) {
            Log.i(tag ?: defaultTag, msg ?: nullStr)
        }
    }

    @JvmStatic
    @JvmOverloads
    fun e(tag: String? = null, msg: String?) {
        if (ISDEBUG) {
            Log.e(tag ?: defaultTag, msg ?: nullStr)
        }
    }

    @JvmStatic
    @JvmOverloads
    fun w(tag: String? = null, msg: String?) {
        if (ISDEBUG) {
            Log.w(tag ?: defaultTag, msg ?: nullStr)
        }
    }

    @JvmStatic
    @JvmOverloads
    fun v(tag: String? = null, msg: String?) {
        if (ISDEBUG) {
            Log.v(tag ?: defaultTag, msg ?: nullStr)
        }
    }

}