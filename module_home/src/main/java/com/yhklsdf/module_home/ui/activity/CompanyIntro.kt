package com.yhklsdf.module_home.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yhklsdf.lib_common.base.BaseSwipeBackActivity
import com.yhklsdf.module_home.R
import kotlinx.android.synthetic.main.activity_company_intro.*

class CompanyIntro : BaseSwipeBackActivity() {
    override fun attachLayoutRes() = R.layout.activity_company_intro

    override fun initData() {
    }

    override fun initView() {
        h_iv_company_info_back.setOnClickListener {
            finish()
        }
    }

    override fun start() {
    }
}
