package com.cb.mvvmbaselibrary.core

import com.cb.mvvmbaselibrary.store.SettingsStore
import com.cb.mvvmbaselibrary.util.setNightMode

object DayNightHelper {
    @JvmStatic
    fun init() {
        setNightMode(SettingsStore.getNightMode())
    }
}