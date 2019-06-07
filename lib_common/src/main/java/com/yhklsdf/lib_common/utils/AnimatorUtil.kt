package com.yhklsdf.lib_common.utils

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator

object AnimatorUtil {

    private val accelerateDecelerateInterpolator : AccelerateDecelerateInterpolator by lazy {
        AccelerateDecelerateInterpolator()
    }

    private val accelerateInterpolator : AccelerateInterpolator by lazy {
        AccelerateInterpolator()
    }

    private val decelerateInterpolator : DecelerateInterpolator by lazy {
        DecelerateInterpolator()
    }

    private val bounceInterpolator : BounceInterpolator by lazy {
        BounceInterpolator()
    }

    private val linearOutSlowInInterpolator : LinearOutSlowInInterpolator by lazy {
        LinearOutSlowInInterpolator()
    }

    fun scaleShow(view: View, listener: ViewPropertyAnimatorListener) {
        view.visibility = View.VISIBLE
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(777)
                .setListener(listener)
                .setInterpolator(linearOutSlowInInterpolator)
                .start()
    }
}