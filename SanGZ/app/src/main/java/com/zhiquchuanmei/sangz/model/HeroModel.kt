package com.zhiquchuanmei.sangz.model

data class HeroModel(
        var id: String,
        var name: String
) {
    var force: Int = 90
    var intelligence = 90
    var command = 90
    var weapon: String = "无"//武器
    var armor: String = "无"//防具
    var mount: String = "无"//坐骑
    var master: String = "在野"//君主
    var like: Int = 90//好感
    var habbit: String = "未知"//喜好
    var position: String = "大都督"//官职
    var where: String = "会稽"//所在
    var skill: String = "无"//技能
    var biographies:String = "暂无"//列传



}