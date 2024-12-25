package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import android.widget.SimpleAdapter.ViewBinder
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.cb.mvvmbaselibrary.dialog.ProgressDialogFragment

/**
 * @author Mr.常
 * @date 2024/12/23 9:30
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var progressDialogFragment: ProgressDialogFragment
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding.root)
    }


    protected abstract fun initViewBinding(): VB

    /**
     * 显示加载(转圈)对话框
     */
    fun showProgressDialog(@StringRes message: Int) {
        if (!this::progressDialogFragment.isInitialized) {
            progressDialogFragment = ProgressDialogFragment.newInstance()
        }
        if (!progressDialogFragment.isAdded) {
            progressDialogFragment.show(supportFragmentManager, message, false)
        }
    }

    /**
     * 隐藏加载(转圈)对话框
     */
    fun dismissProgressDialog() {
        if (this::progressDialogFragment.isInitialized && progressDialogFragment.isVisible) {
            progressDialogFragment.dismissAllowingStateLoss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding == null
    }
}
