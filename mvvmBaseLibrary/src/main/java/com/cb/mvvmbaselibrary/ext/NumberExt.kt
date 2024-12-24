package com.cb.mvvmbaselibrary.ext

import com.cb.mvvmbaselibrary.util.density
import com.cb.mvvmbaselibrary.util.scaledDensity


/**
 * dp、sp、px相互换算
 */
internal fun Number?.dpToPx() = (this?.toFloat() ?: 0f) * density
internal fun Number?.spToPx() = (this?.toFloat() ?: 0f) * scaledDensity
internal fun Number?.pxToDp() = (this?.toFloat() ?: 0f) / density
internal fun Number?.pxToSp() = (this?.toFloat() ?: 0f) / scaledDensity