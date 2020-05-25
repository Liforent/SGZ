package com.zhiquchuanmei.sangz.model

data class PlayerModel(
        var name: String,
        var force: Int,
        var intelligence: Int,
        var command: Int
) {
    var id: String = "001"
    var age: Int = 18
    var weapon: String = "无"//武器
    var armor: String = "无"//防具
    var mount: String = "无"//坐骑
    var soldier: Int = 1000
    var junshi: String = "无"//军师
    var zhushuai: String = "无"//主帅
    var xianfeng: String = "无"//先锋
    var hp: Int = 10//体力
    var money: Int = 100//金钱


}