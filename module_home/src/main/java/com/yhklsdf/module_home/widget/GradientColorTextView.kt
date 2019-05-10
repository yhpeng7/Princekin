package com.yhklsdf.module_home.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.yhklsdf.lib_common.ui.MyTextView

class GradientColorTextView(context: Context, attrs: AttributeSet) : MyTextView(context, attrs) {
    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            paint.shader = LinearGradient(0.toFloat(), 0.toFloat(), width.toFloat(), height.toFloat(), intArrayOf(0X2D6FAA,0X569BD8) , floatArrayOf(0.toFloat(),1.toFloat()) ,Shader.TileMode.CLAMP)
        }
    }
}