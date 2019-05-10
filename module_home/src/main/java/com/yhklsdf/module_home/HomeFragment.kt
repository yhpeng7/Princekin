package com.yhklsdf.module_home

import android.view.View
import com.yhklsdf.lib_common.base.BaseFragment

public class HomeFragment : BaseFragment(){
    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.h_fragment_home

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
    }
}