package com.yhklsdf.module_home.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yhklsdf.module_home.R

class ArcView(context: Context, atts: AttributeSet) : View(context, atts) {

    private var mWidth: Int = 0
    private var mHeight: Int = 0
    private val mArcHeight: Int
    private val mBgColor: Int
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val typedArray = context.obtainStyledAttributes(atts, R.styleable.ArcView)
        mArcHeight = typedArray.getDimensionPixelSize(R.styleable.ArcView_arcHeight,0)
        mBgColor = typedArray.getColor(R.styleable.ArcView_bgColor, Color.parseColor("#4993D6"))
        typedArray.recycle()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        mPaint.style = Paint.Style.FILL
        mPaint.color = mBgColor

        val path = Path()
        path.moveTo(0f,0f)
        path.lineTo(0f,mHeight.toFloat())
        path.quadTo(mWidth / 2f, mHeight - 2f * mArcHeight, mWidth.toFloat(), mHeight.toFloat())
        path.lineTo(mWidth.toFloat(),0f)
        path.close()
        canvas!!.drawPath(path,mPaint)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize
        }
        setMeasuredDimension(mWidth,mHeight)
    }
}