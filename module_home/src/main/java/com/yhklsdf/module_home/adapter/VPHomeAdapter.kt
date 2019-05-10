package com.yhklsdf.module_home.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yhklsdf.module_home.ui.fragment.HonorFragment
import com.yhklsdf.module_home.ui.fragment.PlanFragment

class VPHomeAdapter(val fm: FragmentManager) : FragmentPagerAdapter(fm){

    val fragments = listOf<Fragment>(PlanFragment(), HonorFragment())

    override fun getItem(p0: Int): Fragment {
        return fragments[p0];
    }

    override fun getCount(): Int {
        return fragments.size
    }
}