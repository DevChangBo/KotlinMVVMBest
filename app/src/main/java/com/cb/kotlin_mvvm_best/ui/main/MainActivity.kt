package com.cb.kotlin_mvvm_best.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cb.kotlin_mvvm_best.databinding.ActivityMainBinding
import com.cb.mvvmbaselibrary.base.BaseVmActivity
import com.cb.mvvmbaselibrary.core.Logger
import com.cb.mvvmbaselibrary.core.getSpValue
import com.cb.mvvmbaselibrary.core.putSpValue
import com.cb.mvvmbaselibrary.dialog.WarmingDialog
import com.cb.mvvmbaselibrary.listeners.OnClickListener
import skin.support.SkinCompatManager


class MainActivity : BaseVmActivity<MainViewModel, ActivityMainBinding>() {

    override fun viewModelClass() =MainViewModel::class.java

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnDefault.setOnClickListener {
//            setDayNightMode(0)
            SkinCompatManager.getInstance().restoreDefaultTheme()
        }
        binding.btnNight.setOnClickListener {
//            setDayNightMode(1)
            SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
        }
        binding.btnGreen.setOnClickListener {
//            setDayNightMode(2)
            SkinCompatManager.getInstance().loadSkin("green", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
        }

        binding.btnPopDialog.setOnClickListener {

        }
        binding.btnProDialog.setOnClickListener {
            showProgressDialog(com.cb.mvvmbaselibrary.R.string.loading)
        }

        binding.btnWarmingDialog.setOnClickListener {
            val builder = StringBuilder("正在测试弹框的警告样式")
            builder.append("\n")
            builder.append("123456879")
            WarmingDialog(this, builder.toString(), "", true, object : OnClickListener {
                override fun Onclick(position: Int, state: Int, flag: Boolean) {
                    Logger.d(TAG, "444444444444444444444444${getSpValue("test","0")}")
                }
            }).show()
        }
        putSpValue("test","正在测试，请稍后")

    }


    override fun onBackPressed() {
        super.onBackPressed()
        Logger.d(TAG, "1111111111111111111111111111")
    }


    override fun observe() {
        super.observe()
    }
}

//class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding=ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//}

