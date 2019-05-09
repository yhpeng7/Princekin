package com.yhklsdf.lib_common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.yhklsdf.lib_common.R
import com.yhklsdf.lib_common.app.BaseApplication

object ImageLoader {

    private val isLoadImage = NetworkUtil.isWifi(BaseApplication.instance) || !SettingUtil.getIsNoPhotoMode()

    /**
     * 1，DiskCacheStrategy.NONE// 表示不缓存任何内容
     * 2，DiskCacheStrategy.DATA// 表示只缓存原始图片
     * 3，DiskCacheStrategy.RESOURCE// 表示只缓存转换过后的图片
     * 4，DiskCacheStrategy.ALL // 表示既缓存原始图片，也缓存转换过后的图片
     * 5，DiskCacheStrategy.AUTOMATIC//表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）
     */
    fun load(context: Context, url: Any?, imageView: ImageView) {
        if (isLoadImage) {
            imageView?.let {
                Glide.with(context).clear(it)
                val options = RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .placeholder(R.drawable.placeholder)
                Glide.with(context)
                        .load(url)
                        .transition(DrawableTransitionOptions().crossFade())
                        .apply(options)
                        .into(it)
            }
        }
    }
}