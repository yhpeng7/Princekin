package com.yhklsdf.lib_common.app

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import kotlin.properties.Delegates

open class BaseApplication : Application() {

    companion object {
        private val TAG = "BaseApplication"

        //延迟初始化的非空属性，避免使用不必要的 !! 操作符（使用Delegates.notNull()的属性必须是var）
        var context : Context by Delegates.notNull()
            private set

        lateinit var instance : Application

        lateinit var typeface:Typeface

        fun getTypeFace(): Typeface? {
            return typeface
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        typeface = Typeface.createFromAsset(instance.getAssets(), "fonts/HWSC-REGULAR.OTF")
    }
}