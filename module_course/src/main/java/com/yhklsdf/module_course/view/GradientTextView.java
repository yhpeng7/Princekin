package com.yhklsdf.module_course.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class GradientTextView extends AppCompatTextView {
    public GradientTextView(Context context) {
        super(context);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        LinearGradient gradient = new LinearGradient(
                0, getHeight() / 2,
                getWidth(), getHeight() / 2,
                Color.parseColor("#569BD8"),
                Color.parseColor("#2D6FAA"),
                Shader.TileMode.CLAMP);
        getPaint().setShader(gradient);
        super.onDraw(canvas);
    }
}
