package com.zhiquchuanmei.sangz

import com.zhiquchuanmei.sangz.model.CityModel
import com.zhiquchuanmei.sangz.model.PlayerModel
import com.zhiquchuanmei.sangz.util.JsonReadHelper

object SGConfig {

    public var IS_DEBUG: Boolean = true
    var player: PlayerModel = PlayerModel("", 0, 0, 0)
    fun updatePlayerInfo(model: PlayerModel) {
        player = model
    }

    fun getPlayerInfo(): PlayerModel {
        return player
    }

}