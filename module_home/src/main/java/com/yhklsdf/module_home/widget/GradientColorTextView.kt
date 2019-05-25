package com.yhklsdf.module_home.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import com.yhklsdf.lib_common.ui.MyTextView

class GradientColorTextView(context: Context, attrs: AttributeSet) : MyTextView(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            paint.shader = LinearGradient(0.toFloat(), 0.toFloat(), width.toFloat(), 0.toFloat(), Color.parseColor("#2D6FAA"),Color.parseColor("#569BD8"),Shader.TileMode.CLAMP)
        }
    }
}