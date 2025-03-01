package com.cb.mvvmbaselibrary.core

import android.content.Context
import com.cb.mvvmbaselibrary.App


/**
 * @author Mr.常
 * @date 2024/12/18 9:37
 */

private const val SP_CBMVVM = "sp_cbmvvm"

fun <T> getSpValue(
    key: String,
    defaultVal: T
): T {
    val sp = App.instance.getSharedPreferences(SP_CBMVVM, Context.MODE_PRIVATE)
    return when (defaultVal) {
        is Boolean -> sp.getBoolean(key, defaultVal) as T
        is String -> sp.getString(key, defaultVal) as T
        is Int -> sp.getInt(key, defaultVal) as T
        is Long -> sp.getLong(key, defaultVal) as T
        is Float -> sp.getFloat(key, defaultVal) as T
        is Set<*> -> sp.getStringSet(key, defaultVal as Set<String>) as T
        else -> throw IllegalArgumentException("Unrecognized default value $defaultVal")
    }
}


fun <T> putSpValue(
    key: String,
    value: T
) {
    val editor = App.instance.getSharedPreferences(SP_CBMVVM, Context.MODE_PRIVATE).edit()
    when (value) {
        is Boolean -> editor.putBoolean(key, value)
        is String -> editor.putString(key, value)
        is Int -> editor.putInt(key, value)
        is Long -> editor.putLong(key, value)
        is Float -> editor.putFloat(key, value)
        is Set<*> -> editor.putStringSet(key, value as Set<String>)
        else -> throw UnsupportedOperationException("Unrecognized value $value")
    }
    editor.apply()
}


fun removeSpValue(filename: String = SP_CBMVVM, context: Context, key: String) {
    context.getSharedPreferences(filename, Context.MODE_PRIVATE)
        .edit()
        .remove(key)
        .apply()
}


fun clearSpValue(filename: String = SP_CBMVVM, context: Context) {
    context.getSharedPreferences(filename, Context.MODE_PRIVATE)
        .edit()
        .clear()
        .apply()
}