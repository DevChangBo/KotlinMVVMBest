package com.cb.mvvmbaselibrary.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mr.常 on 2019-12-02.
 */
fun Long.toDateTime(pattern: String): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)