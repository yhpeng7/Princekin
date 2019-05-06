package com.yhklsdf.module_course

import android.view.View
import com.yhklsdf.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_course.*

class CourseFragment : BaseFragment(){
    companion object {
        fun getInstance(): CourseFragment = CourseFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.fragment_course

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
    }
}