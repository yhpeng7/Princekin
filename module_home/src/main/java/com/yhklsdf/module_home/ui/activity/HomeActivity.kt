package com.yhklsdf.module_home.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yhklsdf.module_home.ui.fragment.HomeFragment
import com.yhklsdf.module_home.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.h_activity_home)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }
}
