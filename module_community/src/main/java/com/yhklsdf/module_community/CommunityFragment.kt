package com.yhklsdf.module_community

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.yhklsdf.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_community.*

@Route(path = "/community/fragment")
class CommunityFragment : BaseFragment(){
    companion object {
        fun getInstance(): CommunityFragment = CommunityFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.fragment_community

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
        tv_community_test.setOnClickListener {
            ARouter.getInstance()
                    .build("/course/main")
                    .navigation()
        }
    }
}