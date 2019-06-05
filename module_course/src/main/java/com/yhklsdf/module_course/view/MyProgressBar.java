package com.yhklsdf.module_course.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class MyProgressBar extends ProgressBar {
    private int DEFAULT_COLOR = Color.parseColor("#C8C8C8");
    private int REACHED_COLOR = Color.parseColor("#5195D2");
    private Paint mPaint = new Paint();

    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        // 获取画布的宽高
        int width = getWidth();
        int height = getHeight();
        // 获取进度条的实际宽高
        int lineWidth = width - getPaddingLeft() - getPaddingRight();
        int lineHeight = height - getPaddingTop() - getPaddingBottom();
        // 获取当前进度
        float ratio = getProgress() * 1.0f / getMax();
        // 获取未完成进度大小
        int unreachedWidth = (int) (lineWidth * (1 - ratio));
        // 获取已完成进度大小
        int reachedWidth = lineWidth - unreachedWidth;
        // 绘制已完成进度条，设置画笔颜色和大小
        mPaint.setColor(REACHED_COLOR);
        mPaint.setStrokeWidth(lineHeight);
        // 计算已完成进度条起点和终点的坐标
        int startX = getPaddingLeft();
        int startY = getHeight() / 2;
        int stopX = startX + reachedWidth;
        int stopY = startY;
        // 画线
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
        // 设置画笔颜色
        mPaint.setColor(DEFAULT_COLOR);

        startX = getPaddingLeft() + reachedWidth;
        stopX = width - getPaddingRight();
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }
}
