package com.cb.kotlin_mvvm_best

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.cb.kotlin_mvvm_best.databinding.ActivityMainBinding
import com.cb.mvvmbaselibrary.base.BaseActivity
class MainActivity : BaseActivity<ActivityMainBinding>() {

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

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}


