package com.cb.kotlin_mvvm_best

import com.cb.mvvmbaselibrary.App
import com.cb.mvvmbaselibrary.core.Logger
import skin.support.SkinCompatManager
import skin.support.app.SkinAppCompatViewInflater
import skin.support.constraint.app.SkinConstraintViewInflater
import skin.support.design.app.SkinMaterialViewInflater

class App : App(){
    override fun onCreate() {
        super.onCreate()
        Logger.init(BuildConfig.DEBUG)
        SkinCompatManager.withoutActivity(this)
            .addInflater(SkinMaterialViewInflater()) // material design 控件换肤初始化[可选]
            .addInflater(SkinAppCompatViewInflater())// 基础控件换肤初始化
            .addInflater(SkinConstraintViewInflater())// ConstraintLayout 控件换肤初始化[可选]
            .addInflater(SkinMaterialViewInflater())
            .loadSkin()
    }
}