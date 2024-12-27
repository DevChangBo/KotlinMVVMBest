package com.cb.kotlin_mvvm_best

import com.cb.mvvmbaselibrary.App
import com.cb.mvvmbaselibrary.core.Logger

class App : App(){
    override fun onCreate() {
        super.onCreate()
        Logger.init(BuildConfig.DEBUG)
    }
}