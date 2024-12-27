package com.cb.mvvmbaselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


/**
 * @author Mr.常
 * @date 2024/12/23 12:37
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected val TAG:String=javaClass.name
    protected lateinit var binding: VB
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = initViewBinding()
        return binding.root
    }

    protected abstract fun initViewBinding(): VB

    override fun onDestroy() {
        super.onDestroy()
        binding == null
    }
}
