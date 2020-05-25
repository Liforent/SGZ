package com.zhiquchuanmei.sangz.helper

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.zhiquchuanmei.sangz.ui.df.SGEditInfoDialogFragment
import com.zhiquchuanmei.sangz.ui.df.SGHeroInfoDialogFragment

object SGDialogfragmentHelper {
    @JvmStatic
    fun showEditInfoDF(fragmentManager: FragmentManager){
        val fragment:SGEditInfoDialogFragment = SGEditInfoDialogFragment()
        fragment.show(fragmentManager,"EditInfoDialogFragment")
    }
    @JvmStatic
    fun showHeroInfo(fragmentManager: FragmentManager,name: String) {
        val fragment:SGHeroInfoDialogFragment = SGHeroInfoDialogFragment()
        var bundle:Bundle = Bundle()
        bundle.putString("NAME",name)
        fragment.setArguments(bundle)
        fragment.show(fragmentManager,"SGHeroInfoDialogFragment")
    }
}