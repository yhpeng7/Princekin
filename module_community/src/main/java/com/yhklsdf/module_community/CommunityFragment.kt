package com.yhklsdf.module_community

import android.view.View
import com.yhklsdf.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : BaseFragment(){
    companion object {
        fun getInstance(): CommunityFragment = CommunityFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.fragment_community

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
        tv_home_test.text = "Community"
    }
}