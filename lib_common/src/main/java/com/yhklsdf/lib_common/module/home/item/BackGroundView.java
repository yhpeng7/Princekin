package com.yhklsdf.lib_common.module.home.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

//用于绘制Dialog圆边背景
public class BackGroundView extends View {
    public BackGroundView(Context context) {
        super(context);
    }

    public BackGroundView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public BackGroundView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        int bottom = getBottom();
        int right = getRight();
        
        Path path = new Path(); //创建path用于裁剪圆边
        float[] arrays = {0f, 0f, 0f, 0f, 30f, 30f, 30f, 30f};
        path.addRoundRect(new RectF(0, 0, getWidth(), getHeight()), arrays, Path.Direction.CW); //将Path规定的区域创成RectF并加入
        
        canvas.clipPath(path);  //画布裁剪成带圆边的方形
        canvas.drawCircle(right / 2, bottom, getHeight(), paint);   //以画布坐标(width/2,height)为原点绘制一个圆
    }
}
