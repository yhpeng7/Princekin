package com.yhklsdf.module_home.ui.fragment

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import android.view.View
import com.yhklsdf.lib_common.base.BaseFragment
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.adapter.VPHomeAdapter
import kotlinx.android.synthetic.main.h_fragment_home.*
import kotlinx.android.synthetic.main.h_toolbar.*
import org.jetbrains.anko.textColorResource

class HomeFragment : BaseFragment() {
    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun useEventBus(): Boolean = false

    override fun attachLayoutRes(): Int = R.layout.h_fragment_home

    override fun lazyLoad() {
    }

    override fun initView(view: View) {
        setPlan()
        vp_home.adapter = VPHomeAdapter(childFragmentManager)

        vp_home.setOnPageChangeListener(pageChangeListener)

        h_tv_plan.setOnClickListener {
            setPlan()
            vp_home.currentItem = 0
        }
        h_tv_honor.setOnClickListener {
            setHonor()
            vp_home.currentItem = 1
        }
    }

    private val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            if (p0 == 0) {
                setPlan()
            } else {
                setHonor()
            }
        }
    }

    fun setPlan() {
        h_tv_plan.setBackgroundResource(R.drawable.h_tb_bg)
        h_tv_plan.textColorResource = R.color.white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            h_tv_plan.elevation = 7.toFloat()
        }
        h_tv_honor.setBackgroundResource(0)
        h_tv_honor.textColorResource = R.color.black
    }

    fun setHonor() {
        h_tv_plan.setBackgroundResource(0)
        h_tv_plan.textColorResource = R.color.black
        h_tv_honor.setBackgroundResource(R.drawable.h_tb_bg)
        h_tv_honor.textColorResource = R.color.white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            h_tv_honor.elevation = 7.toFloat()
        }
    }
}