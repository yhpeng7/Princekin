package com.yhklsdf.module_home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.h_activity_home)
        supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragment()).commit()
    }
}
