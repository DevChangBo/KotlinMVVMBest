package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

/**
 * @author Mr.常
 * @date 2024/12/24 9:30
 */
abstract class BaseVmActivity<VM : BaseViewModel> : BaseActivity() {

    protected open lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        observe()
        initView()
        initData()
    }

    /**
     * 初始化ViewModel
     */
    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(viewModelClass())
    }


    /**
     * 获取ViewModel的class
     */
    protected abstract fun viewModelClass(): Class<VM>

    /**
     * 订阅，LiveData、Bus
     */
    open fun observe() {
    }

    /**
     * 数据初始化相关
     */
    open fun initView() {
        // Override if need
    }

    /**
     * 懒加载数据
     */
    open fun initData() {
        // Override if need
    }



}
