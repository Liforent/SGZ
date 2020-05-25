package com.zhiquchuanmei.sangz.ui.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhiquchuanmei.sangz.R
import com.zhiquchuanmei.sangz.ui.fragment.SGFragmentTabMap
import com.zhiquchuanmei.sangz.ui.fragment.SGFragmentTabShop
import kotlinx.android.synthetic.main.activity_game_main.*

class GameMainActivity : SGBaseActivity() {
    private lateinit var fragmentList: MutableList<Fragment>
    private val titleList = listOf("地图", "商店", "情报", "背包", "英雄", "系统")
    private val itemIdList = listOf("001", "002", "003", "004", "005", "006")

    override fun getLayoutId(): Int {
        return R.layout.activity_game_main
    }

    override fun initView() {
        initTabLayout()

    }

    private fun initTabLayout() {
        fragmentList = ArrayList()
        fragmentList.add(SGFragmentTabMap())
        fragmentList.add(SGFragmentTabShop())
        fragmentList.add(SGFragmentTabMap())
        fragmentList.add(SGFragmentTabMap())
        fragmentList.add(SGFragmentTabMap())
        fragmentList.add(SGFragmentTabMap())

        viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment = fragmentList[position]

            override fun getItemCount(): Int = fragmentList.size
        }
        viewPager2.offscreenPageLimit = 3
        tab_layout.tabMode = TabLayout.MODE_FIXED
        tab_layout.setSelectedTabIndicatorColor(resources.getColor(R.color.yellow))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

        val tabLayoutMediator = TabLayoutMediator(tab_layout, viewPager2) { tab, position ->
            tab.text = titleList[position]
        }

        tabLayoutMediator.attach()

    }

    override fun initEvent() {
    }
}