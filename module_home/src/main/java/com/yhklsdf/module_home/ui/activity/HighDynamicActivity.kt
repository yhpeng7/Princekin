package com.yhklsdf.module_home.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.yhklsdf.lib_common.base.BaseSwipeBackActivity
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.adapter.RVHighDynamicAdapter
import com.yhklsdf.module_home.bean.HighDynamicBean
import kotlinx.android.synthetic.main.activity_high_dynamic.*

class HighDynamicActivity : BaseSwipeBackActivity() {

    val data = mutableListOf(
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万"),
            HighDynamicBean("Java开发",R.drawable.ssdk_oks_classic_youdao,"深圳腾讯有限公司","上市公司|互联网|2000+人","80万")
    )

    override fun attachLayoutRes() = R.layout.activity_high_dynamic

    override fun initData() {

    }

    override fun initView() {
        h_high_dynamic_rv.layoutManager = LinearLayoutManager(this)
        val adapter = RVHighDynamicAdapter(this,data)
        adapter.setHeaderView(layoutInflater.inflate(R.layout.h_header_high_dynamic,h_high_dynamic_rv,false))
        h_high_dynamic_rv.adapter = adapter

        h_high_dynamic_iv_1.setOnClickListener { finish() }
    }

    override fun start() {
    }
}
