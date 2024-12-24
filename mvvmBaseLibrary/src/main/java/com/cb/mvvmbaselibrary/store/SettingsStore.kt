package com.cb.mvvmbaselibrary.store

import com.cb.mvvmbaselibrary.App
import com.cb.mvvmbaselibrary.core.getSpValue
import com.cb.mvvmbaselibrary.core.putSpValue

/**
 * @author Mr.常
 * @date 2024/12/18 9:37
 */
object SettingsStore {

    private const val SP_SETTINGS = "sp_settings"
    private const val DEFAULT_WEB_TEXT_ZOOM = 100
    private const val KEY_WEB_TEXT_ZOOM = "key_web_text_zoom"
    private const val KEY_NIGHT_MODE = "key_night_mode"

    fun setWebTextZoom(textZoom: Int) =
        putSpValue(SP_SETTINGS, App.instance, KEY_WEB_TEXT_ZOOM, textZoom)

    fun getWebTextZoom() =
        getSpValue(SP_SETTINGS, App.instance, KEY_WEB_TEXT_ZOOM, DEFAULT_WEB_TEXT_ZOOM)

    fun setNightMode(nightMode: Boolean) =
        putSpValue(SP_SETTINGS, App.instance, KEY_NIGHT_MODE, nightMode)

    fun getNightMode() =
        getSpValue(SP_SETTINGS, App.instance, KEY_NIGHT_MODE, false)
}