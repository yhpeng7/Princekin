package com.yhklsdf.module_home.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yhklsdf.lib_common.base.BaseSwipeBackActivity
import com.yhklsdf.module_home.R
import com.yhklsdf.module_home.adapter.RVSaBAdapter
import com.yhklsdf.module_home.bean.SaBBean
import com.yhklsdf.module_home.utils.GlideImageLoader
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_sa_b.*

class SaBActivity : BaseSwipeBackActivity() {
    val data = mutableListOf(
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15"),
            SaBBean(R.drawable.ssdk_oks_classic_youdao,"胡**","创咖创立者","关于创业，我想说的是...","5.15")
    )

    val images = mutableListOf(
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder
    )

    override fun attachLayoutRes() = R.layout.activity_sa_b

    override fun initData() {
    }

    override fun initView() {
        h_sab_rv.layoutManager = LinearLayoutManager(this)
        val adapter = RVSaBAdapter(this, data)
        val headerView = layoutInflater.inflate(R.layout.h_header_sab,h_sab_rv,false)
        val banner : Banner = headerView.findViewById(R.id.h_sab_head)
        banner.setImages(images)
                .setImageLoader(GlideImageLoader())
                .setIndicatorGravity(BannerConfig.CENTER)
                .isAutoPlay(true)
                .start()
        adapter.addHeaderView(headerView)
        h_sab_rv.adapter = adapter

        h_sab_back.setOnClickListener { finish() }
    }

    override fun start() {
    }
}
