package com.zhiquchuanmei.sangz.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.zhiquchuanmei.sangz.R
import com.zhiquchuanmei.sangz.helper.SGDialogfragmentHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.df_edit_info.*
import kotlinx.android.synthetic.main.df_edit_info.tv_start

class GameStartActivity : SGBaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv_start.setOnClickListener {
            SGDialogfragmentHelper.showEditInfoDF(supportFragmentManager)
        }
    }

    override fun initEvent() {
        tv_start.setOnClickListener {
            SGDialogfragmentHelper.showEditInfoDF(supportFragmentManager)
        }
    }


}