package com.yhklsdf.lib_common.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import com.yhklsdf.lib_common.R
import com.yhklsdf.lib_common.ui.MyTextView

class GradientColorTextView(context: Context, attrs: AttributeSet) : MyTextView(context, attrs) {

    private val startColor : Int
    private val endColor : Int

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientColorTextView)
        startColor = typedArray.getColor(R.styleable.GradientColorTextView_startColor,Color.parseColor("#2D6FAA"))
        endColor = typedArray.getColor(R.styleable.GradientColorTextView_endColor, Color.parseColor("#569BD8"))
        typedArray.recycle()
    }

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            paint.shader = LinearGradient(0.toFloat(), 0.toFloat(), width.toFloat(), 0.toFloat(),startColor ,endColor,Shader.TileMode.CLAMP)
        }
    }
}