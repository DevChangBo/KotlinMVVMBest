package com.cb.mvvmbaselibrary.ext

import androidx.core.text.HtmlCompat

/**
 * Created by Mr.常 on 2019-11-21.
 */
fun String?.htmlToSpanned() =
    if (this.isNullOrEmpty()) "" else HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)