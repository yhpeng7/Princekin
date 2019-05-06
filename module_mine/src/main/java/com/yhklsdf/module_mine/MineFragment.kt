package com.yhklsdf.module_mine

import android.view.View
import com.yhklsdf.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

public class MineFragment : BaseFragment(){
    companion object {
        fun getInstance(): MineFragment = MineFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.fragment_mine

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
        tv_mine_test.text = "Mine"
    }
}