package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cb.mvvmbaselibrary.dialog.ProgressDialogFragment


/**
 * @author Mr.常
 * @date 2024/12/23 12:37
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected val TAG:String=javaClass.name
    private lateinit var progressDialogFragment: ProgressDialogFragment
    protected lateinit var binding: VB
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = initViewBinding()
        return binding.root
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
            progressDialogFragment.show(childFragmentManager, message, false)
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
    }
}
