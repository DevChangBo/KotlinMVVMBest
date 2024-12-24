package com.cb.kotlin_mvvm_best

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.cb.mvvmbaselibrary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.tv_message

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv_message.text = "Hello World!!!!!"
    }
}


