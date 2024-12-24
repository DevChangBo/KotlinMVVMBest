package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

/**
 * @author Mr.常
 * @date 2024/12/24 13:05
 */
abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {

    protected lateinit var mViewModel: VM
    private var lazyLoaded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        observe()
        initView()
        initData()
    }

    override fun onResume() {
        super.onResume()
        // 实现懒加载
        if (!lazyLoaded) {
            lazyLoadData()
            lazyLoaded = true
        }
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
    abstract fun viewModelClass(): Class<VM>

    /**
     * 订阅，LiveData、Bus
     */
    open fun observe() {

    }

    /**
     * View初始化相关
     */
    open fun initView() {
        // Override if need
    }

    /**
     * 数据初始化相关
     */
    open fun initData() {
        // Override if need
    }

    /**
     * 懒加载数据
     */
    open fun lazyLoadData() {
        // Override if need
    }


}
