package com.yhklsdf.module_community

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route

class CommunityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)
        supportFragmentManager.beginTransaction().replace(R.id.container, CommunityFragment()).commit()
    }
}
