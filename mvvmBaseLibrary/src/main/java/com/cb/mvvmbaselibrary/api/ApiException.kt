package com.cb.mvvmbaselibrary.api

/**
 * @author Mr.常
 * @date 2024/12/23 9:37
 */
class ApiException(var code: Int, override var message: String) : RuntimeException()