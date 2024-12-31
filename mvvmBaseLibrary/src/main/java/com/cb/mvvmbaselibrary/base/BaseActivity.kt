package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import android.widget.SimpleAdapter.ViewBinder
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.SkinAppCompatDelegateImpl
import androidx.viewbinding.ViewBinding
import com.cb.mvvmbaselibrary.dialog.ProgressDialogFragment
import skin.support.SkinCompatManager

/**
 * @author Mr.常
 * @date 2024/12/23 9:30
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected val TAG:String=javaClass.name
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



    override fun getDelegate(): AppCompatDelegate {
        return SkinAppCompatDelegateImpl.get(this, this)
    }

    fun setDayNightMode(isNightMode: Int) {
        if (isNightMode == 0) {
            SkinCompatManager.getInstance().restoreDefaultTheme()
        }else if (isNightMode == 1) {
            SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);// 后缀加载
        }else if (isNightMode == 2) {
            SkinCompatManager.getInstance().loadSkin("green", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
        }

    }


    override fun onDestroy() {
        super.onDestroy()
    }
}
