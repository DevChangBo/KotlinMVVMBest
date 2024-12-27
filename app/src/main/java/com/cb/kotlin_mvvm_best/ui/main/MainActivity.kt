package com.cb.kotlin_mvvm_best.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.cb.kotlin_mvvm_best.databinding.ActivityMainBinding
import com.cb.mvvmbaselibrary.base.BaseActivity
import com.cb.mvvmbaselibrary.base.BaseVmActivity

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
    }

    override fun viewModelClass() =MainViewModel::class.java

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun observe() {
        super.observe()
    }
}


