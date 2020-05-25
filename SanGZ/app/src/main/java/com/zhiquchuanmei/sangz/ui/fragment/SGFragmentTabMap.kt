package com.zhiquchuanmei.sangz.ui.fragment

import android.view.View
import com.zhiquchuanmei.sangz.MyApplication
import com.zhiquchuanmei.sangz.R
import com.zhiquchuanmei.sangz.helper.SGDialogfragmentHelper
import com.zhiquchuanmei.sangz.model.CityModel
import com.zhiquchuanmei.sangz.model.HeroModel
import com.zhiquchuanmei.sangz.model.PlayerModel
import com.zhiquchuanmei.sangz.util.ZLog
import kotlinx.android.synthetic.main.sg_fragment_tab_map.*
import org.json.JSONObject


class SGFragmentTabMap : SGBaseFragment() {
    lateinit var player: PlayerModel
    lateinit var city: CityModel
    lateinit var cityHeroes: ArrayList<HeroModel>
    lateinit var fieldHeroes: ArrayList<HeroModel>
    private var random: Int = 0
    private var searchEventKind:Int = 0
    var SERARCH_EVENT_KIND_NOTHING = 0
    var SERARCH_EVENT_KIND_HERO = 1
    var SERARCH_EVENT_KIND_GOODS = 2
    var SERARCH_EVENT_KIND_CHANCE = 3//机遇



    override fun getContentLayoutId(): Int {
        return R.layout.sg_fragment_tab_map
    }

    override fun afterViewCreated(view: View) {
        player = MyApplication.instance.getPlayerInfo()
        city = MyApplication.instance.getCityInfo("会稽")!!
        cityHeroes = ArrayList<HeroModel>()
        fieldHeroes = ArrayList<HeroModel>()
        for (item in city.fieldHeroes) {
            cityHeroes.add(MyApplication.instance.getHeroInfo(item)!!)
        }
        for (item in city.fieldHeroes) {
            fieldHeroes.add(MyApplication.instance.getHeroInfo(item)!!)
        }
        ZLog.e(city.name)
        initData()
        initEvent()
    }


    private fun initData() {
        tv_command.setText(player.command.toString())
        tv_armor.setText(player.armor.toString())
        tv_force.setText(player.force.toString())
        tv_intelligence.setText(player.intelligence.toString())
        tv_hp.setText(player.hp.toString())
        tv_money.setText(player.money.toString())
        tv_soldier.setText(player.soldier.toString())
        tv_weapon.setText(player.weapon)
        tv_mount.setText(player.mount)
        tv_zhushuai.setText(player.zhushuai)
        tv_junshi.setText(player.junshi)
        tv_xianfeng.setText(player.xianfeng)
        tv_city.setText(city.name)
        tv_city_defence.setText(city.defence.toString())
        tv_population.setText(city.population.toString())
        tv_owner.setText(city.ownerName)
        tv_city_zhushuai.setText(city.zhujiang)
        tv_city_soldier.setText(city.soldier.toString())
        tv_city_hero.setText(city.cityHeroes.size.toString())
        tv_unemployed_hero.setText(city.fieldHeroes.size.toString())
        tv_event_title.setText("你来到了")
        tv_event_target.setText(city.name)

    }

    private fun initEvent() {
        tv_search.setOnClickListener {
            search()
        }
        tv_consume.setOnClickListener {
            search()
        }
        tv_attack.setOnClickListener {
            search()
        }
        tv_strategy.setOnClickListener {
            search()
        }
        tv_event_target.setOnClickListener {
            //SGDialogfragmentHelper.showHeroInfo()
            when(searchEventKind){
                SERARCH_EVENT_KIND_HERO ->
                    SGDialogfragmentHelper.showHeroInfo(childFragmentManager,tv_event_target.text.toString())
            }
        }
    }

    private fun search() {
        random = (0..10).random()
        ZLog.e(random.toString())
        when {
            random < 3 -> {
                tv_event_title.setText("你在城中转了一圈，一无所获")
                tv_event_target.setText("")
                searchEventKind = SERARCH_EVENT_KIND_NOTHING
            }
            random in(3..8) ->{
                if(fieldHeroes.size > 0){
                    val randomFieldHero = (0..fieldHeroes.size-1).random()
                    tv_event_title.setText("你在城中四川溜达，居然偶遇到了")
                    tv_event_target.setText(fieldHeroes[randomFieldHero].name)
                    searchEventKind = SERARCH_EVENT_KIND_HERO
                    tv_event_target.setOnClickListener {
                        //SGDialogfragmentHelper.showHeroInfo()
                        when(searchEventKind){
                            SERARCH_EVENT_KIND_HERO ->
                                SGDialogfragmentHelper.showHeroInfo(childFragmentManager,fieldHeroes[randomFieldHero].name)
                        }
                    }

                }else{
                    tv_event_title.setText("你在城中转了一圈，一无所获")
                    tv_event_target.setText("")
                    searchEventKind = SERARCH_EVENT_KIND_NOTHING
                }

            }
            random > 8 ->{
                tv_event_title.setText("你在城中转了一圈，居然发现了")
                tv_event_target.setText("大砍刀")
                searchEventKind = SERARCH_EVENT_KIND_GOODS
            }
        }
    }


}