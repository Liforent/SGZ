package com.zhiquchuanmei.sangz

import android.app.Application
import android.content.Context
import com.alibaba.fastjson.JSONArray
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zhiquchuanmei.sangz.model.CityModel
import com.zhiquchuanmei.sangz.model.HeroModel
import com.zhiquchuanmei.sangz.model.PlayerModel
import com.zhiquchuanmei.sangz.util.JsonReadHelper
import com.zhiquchuanmei.sangz.util.ZLog
import org.json.JSONObject


class MyApplication : Application() {
    var player: PlayerModel = PlayerModel("", 0, 0, 0)
    lateinit var cities: MutableList<CityModel>
    lateinit var heroes: MutableList<HeroModel>

    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
            private set

        @JvmStatic
        lateinit var mContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mContext = applicationContext
        readPlayerInfo()
        initCityInfo()
        initHeroInfo()
    }

    private fun initCityInfo() {
        val json = JSONObject(JsonReadHelper.readJson(this, "cityInfo.json"))
        val array = json.getJSONArray("cities").toString()
        cities = Gson().fromJson(array, object : TypeToken<List<CityModel?>?>() {}.getType())
    }
    private fun initHeroInfo() {
        val json = JSONObject(JsonReadHelper.readJson(this, "heroInfo.json"))
        val array = json.getJSONArray("heroes").toString()
        heroes = Gson().fromJson(array, object : TypeToken<List<HeroModel?>?>() {}.getType())
    }

    fun readPlayerInfo() {

    }

    fun updatePlayerInfo(model: PlayerModel) {
        player = model
    }

    fun getPlayerInfo(): PlayerModel {
        return player
    }

    fun getCityInfo(cityName: String): CityModel? {
        for (item in cities) {
            if (item.name == cityName)
                return item
        }
        return null
    }

    fun getHeroInfo(heroName:String):HeroModel?{
        for(item in heroes){
            if(item.name == heroName)
                return item
        }
        return null
    }
    fun getCityHeroes(cityName:String):List<HeroModel>{
        val cityHeroes = ArrayList<HeroModel>()
        for(item in heroes){
            if(item.where == cityName  && item.master != "无")
                cityHeroes.add(item)
        }
        return cityHeroes
    }
    fun getCityUnEmployedHeroes(cityName:String):List<HeroModel>{
        val cityHeroes = ArrayList<HeroModel>()
        for(item in heroes){
            if(item.where == cityName && item.master == "无")
                cityHeroes.add(item)
        }
        return cityHeroes
    }

}