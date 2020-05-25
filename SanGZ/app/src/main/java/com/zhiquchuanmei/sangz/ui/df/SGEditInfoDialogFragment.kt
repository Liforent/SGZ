package com.zhiquchuanmei.sangz.ui.df

import android.content.Intent
import com.zhiquchuanmei.sangz.MyApplication
import com.zhiquchuanmei.sangz.R
import com.zhiquchuanmei.sangz.model.PlayerModel
import com.zhiquchuanmei.sangz.ui.activity.GameMainActivity
import com.zhiquchuanmei.sangz.util.ZLog
import kotlinx.android.synthetic.main.df_edit_info.*

class SGEditInfoDialogFragment:SGBaseFullScreenDialogFragment() {
    private var force:Int = 0
    private var intelligence:Int = 0
    private var command:Int = 0
    private var random:Int = 0

    override fun initView() {
        makeRandom()
    }

    private fun makeRandom() {
        random = (30..90).random()
        force = random
        random = (30..90).random()
        command = random
        random = (30..90).random()
        intelligence = random
        tv_force.setText(force.toString())
        tv_intelligence.setText(intelligence.toString())
        tv_command.setText(command.toString())
    }

    override fun initEvent() {
        tv_reset.setOnClickListener {
            makeRandom()

        }
        tv_start.setOnClickListener {
            val playerModel = PlayerModel(tv_name.text.toString(),force,intelligence,command)
            ZLog.e(playerModel.force.toString())
            MyApplication.instance.updatePlayerInfo(playerModel)
            startActivity(Intent(requireContext(),GameMainActivity::class.java))
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.df_edit_info
    }
    

}