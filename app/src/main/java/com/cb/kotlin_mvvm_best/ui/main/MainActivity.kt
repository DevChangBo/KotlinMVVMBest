package com.cb.kotlin_mvvm_best.ui.main

import android.os.Bundle
import com.cb.kotlin_mvvm_best.databinding.ActivityMainBinding
import com.cb.mvvmbaselibrary.base.BaseVmActivity
import com.cb.mvvmbaselibrary.core.Logger
import com.cb.mvvmbaselibrary.dialog.WarmingDialog
import com.cb.mvvmbaselibrary.listeners.OnClickListener

class MainActivity : BaseVmActivity<MainViewModel,ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvMessage.text = "Hello World!!!!!"

        binding.btnDefault.setOnClickListener {
           setDayNightMode(0)
        }
        binding.btnNight.setOnClickListener {
            setDayNightMode(1)
        }
        binding.btnGreen.setOnClickListener {
            setDayNightMode(2)
        }

        binding.btnWarmingDialog.setOnClickListener {
            val builder = StringBuilder("正在测试弹框的警告样式")
            builder.append("\n")
            builder.append("123456879")
            WarmingDialog(this, builder.toString(), "", true, object : OnClickListener {
                override fun Onclick(position: Int, state: Int, flag: Boolean) {
                    Logger.d(TAG, "444444444444444444444444")
                }
            }).show()
        }
        Logger.d(TAG, "111111111111111111111111111111111111111")
        Logger.d(TAG, "222222222222222222222222222222222222222")
        mViewModel.TestLogger()
    }

    override fun viewModelClass() =MainViewModel::class.java

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun observe() {
        super.observe()
    }
}


