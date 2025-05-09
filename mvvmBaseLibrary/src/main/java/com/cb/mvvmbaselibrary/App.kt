package com.cb.mvvmbaselibrary

import android.app.Application
import com.cb.mvvmbaselibrary.core.ActivityHelper
import com.cb.mvvmbaselibrary.core.CoilHelper
import com.cb.mvvmbaselibrary.util.isMainProcess

/**
 * @author Mr.常
 * @date 2024/12/23 9:37
 */
open class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // 主进程初始化
        if (isMainProcess(this)) {
            init()
        }
    }

    private fun init() {
        CoilHelper.init(this)
        ActivityHelper.init(this)
//        DayNightHelper.init()
    }

}