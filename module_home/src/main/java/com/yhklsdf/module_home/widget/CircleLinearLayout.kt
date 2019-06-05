package com.yhklsdf.module_home.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.LinearLayout
import com.yhklsdf.lib_common.ext.loge

class CircleLinearLayout(context: Context?, attr: AttributeSet) : LinearLayout(context, attr) {
    override fun draw(canvas: Canvas?) {
        val path = Path()
        val radius = if(width < height) width / 2f else height / 2f
        path.addCircle(radius,radius,radius,Path.Direction.CW)
        canvas!!.clipPath(path)
        super.draw(canvas)
    }
}