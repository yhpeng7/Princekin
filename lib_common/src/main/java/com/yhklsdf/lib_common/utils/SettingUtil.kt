package com.yhklsdf.lib_common.utils

import android.preference.PreferenceManager
import com.yhklsdf.lib_common.app.BaseApplication

object SettingUtil {
    private val setting = PreferenceManager.getDefaultSharedPreferences(BaseApplication.context)

    /**
     * 获取是否开启无图模式
     */
    fun getIsNoPhotoMode(): Boolean {
        return setting.getBoolean("switch_noPhotoMode",false)
    }
}