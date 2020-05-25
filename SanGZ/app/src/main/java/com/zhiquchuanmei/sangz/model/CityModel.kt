package com.zhiquchuanmei.sangz.model

import java.util.ArrayList

data class CityModel(
        var id: String,
        var name: String
) {
    var population:Int = 220022
    var ownerName: String = "刘备"//所属
    var zhujiang: String = "关逼王"//主将
    var defence: Int = 100//城防
    var soldier: Int = 1000//士兵
    var cityHeroes: List<String> = ArrayList<String>()//武将
    var fieldHeroes: List<String> = ArrayList<String>()//在野
    var special: String = "无"//城池特色

}