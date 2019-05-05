package com.yhklsdf.module_mine

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yhklsdf.module_mine.R

class MineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)
        supportFragmentManager.beginTransaction().replace(R.id.container, MineFragment()).commit()
    }
}
