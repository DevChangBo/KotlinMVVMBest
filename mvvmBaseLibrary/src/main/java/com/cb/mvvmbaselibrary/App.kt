package com.cb.mvvmbaselibrary

import android.app.Application
import com.cb.mvvmbaselibrary.core.ActivityHelper
import com.cb.mvvmbaselibrary.core.CoilHelper
import com.cb.mvvmbaselibrary.core.DayNightHelper
import com.cb.mvvmbaselibrary.loadmore.LoadMoreHelper
import com.cb.mvvmbaselibrary.util.isMainProcess
import skin.support.SkinCompatManager
import skin.support.app.SkinAppCompatViewInflater
import skin.support.constraint.app.SkinConstraintViewInflater
import skin.support.design.app.SkinMaterialViewInflater

/**
 * @author Mr.常
 * @date 2024/12/23 9:37
 */
class App : Application() {

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
        LoadMoreHelper.init()
        CoilHelper.init(this)
        ActivityHelper.init(this)
        SkinCompatManager.withoutActivity(this)
            .addInflater(SkinAppCompatViewInflater())
            .addInflater(SkinConstraintViewInflater())
            .addInflater(SkinMaterialViewInflater())
            .loadSkin()
//        DayNightHelper.init()
    }

}