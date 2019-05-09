package com.yhklsdf.module_home.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.yhklsdf.module_home.R
import com.youth.banner.loader.ImageLoader

class GlideImageLoader : ImageLoader(){
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.placeholder)
        Glide.with(context!!)
                .load(path)
                .transition(DrawableTransitionOptions().crossFade())
                .apply(options)
                .into(imageView!!)
    }
}