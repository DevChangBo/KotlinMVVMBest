package com.cb.kotlin_mvvm_best.ui.main

import com.cb.mvvmbaselibrary.base.BaseViewModel
import com.cb.mvvmbaselibrary.core.Logger

class MainViewModel : BaseViewModel() {
    fun TestLogger(){
        Logger.d(TAG,"33333333333333333333")
    }
}