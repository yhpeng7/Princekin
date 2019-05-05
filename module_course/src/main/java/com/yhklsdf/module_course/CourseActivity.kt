package com.yhklsdf.module_course

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        supportFragmentManager.beginTransaction().replace(R.id.container, CourseFragment()).commit()
    }
}
