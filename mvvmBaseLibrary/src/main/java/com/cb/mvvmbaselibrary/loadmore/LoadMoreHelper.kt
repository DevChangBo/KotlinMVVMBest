package com.cb.mvvmbaselibrary.loadmore

import com.chad.library.adapter.base.module.LoadMoreModuleConfig

object LoadMoreHelper {

    @JvmStatic
    fun init() {
        LoadMoreModuleConfig.defLoadMoreView = CommonLoadMoreView()
    }
}