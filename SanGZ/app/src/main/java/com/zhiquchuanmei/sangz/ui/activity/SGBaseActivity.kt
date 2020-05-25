package com.zhiquchuanmei.sangz.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class SGBaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initEvent()
    }

    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initEvent()
}