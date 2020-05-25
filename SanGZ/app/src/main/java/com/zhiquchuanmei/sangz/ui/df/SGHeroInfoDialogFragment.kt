package com.zhiquchuanmei.sangz.ui.df

import com.zhiquchuanmei.sangz.MyApplication
import com.zhiquchuanmei.sangz.R
import com.zhiquchuanmei.sangz.model.HeroModel
import com.zhiquchuanmei.sangz.util.ZLog
import kotlinx.android.synthetic.main.sg_fragment_hero_info.*

class SGHeroInfoDialogFragment : SGBaseFullScreenDialogFragment() {
    var name: String = ""
    lateinit var hero: HeroModel
    var palyer = MyApplication.instance.getPlayerInfo()
    var options: Int = 0
    var OPTIONS_CHAT = 0
    var OPTIONS_FIGHT = 1
    var OPTIONS_DRINK = 2
    var recruitNumber :Int = 0//招募值
    var random = (0..10).random()
    override fun initEvent() {
        tv_back.setOnClickListener { dismiss() }
        tv_drink.setOnClickListener {
            options = OPTIONS_DRINK
            makeChoice()
        }
        tv_chat.setOnClickListener {
            options = OPTIONS_CHAT
            makeChoice()
        }
        tv_fight.setOnClickListener {
            options = OPTIONS_FIGHT
            makeChoice()
        }
        tv_recruit.setOnClickListener {
            //招募，主公智力越高越容易招募，好感越高越容易招募，武将三维越高越难招募
            random = (0..100).random()
            ZLog.e(random.toString()+"  "+recruitNumber.toString())
            if(random < recruitNumber){
                tv_realtiame_message.setText("${name}:愿为主公效劳！！")
            }else{
                tv_realtiame_message.setText("${name}:将军请回，容在下考虑一番。")
            }
        }
    }

    private fun makeChoice() {
        when(options){
            OPTIONS_DRINK->{
                //把酒言欢，爱好酒每次增加好感翻倍。每次增加量等于
                if(random>7){
                    tv_realtiame_message.setText("酒过三巡，两人只觉相见恨晚。${name}屁颠颠的加入了你！")
                }else{
                    tv_realtiame_message.setText("${name}与你聊了三分钟，不欢而散。")
                }
            }
            OPTIONS_CHAT->{
                var myIntelligence = MyApplication.instance.getPlayerInfo().intelligence
               // if(myIntelligence > hero.intelligence)
            }
        }
        tv_realtiame_message.setText("${name}与你聊了三分钟，不欢而散。")
    }

    override fun initView() {
        name = arguments?.get("NAME").toString()

        hero = MyApplication.instance.getHeroInfo(name)!!
        tv_name.setText(hero.name)
        tv_command.setText(hero.command.toString())
        tv_force.setText(hero.force.toString())
        tv_intelligence.setText(hero.intelligence.toString())
        tv_skill.setText(hero.skill)
        tv_like.setText(hero.like.toString())
        tv_habbit.setText(hero.habbit)
        tv_weapon.setText(hero.weapon)
        tv_armor.setText(hero.armor)
        tv_mount.setText(hero.mount)
        tv_master.setText(hero.master)
        tv_where.setText(hero.where)
        tv_position.setText(hero.position)
        tv_biographies.setText(hero.biographies)
        recruitNumber = palyer.intelligence +hero.like - (hero.intelligence+hero.command+hero.force)/3

    }

    override fun getLayoutID(): Int {
        return R.layout.sg_fragment_hero_info
    }

}