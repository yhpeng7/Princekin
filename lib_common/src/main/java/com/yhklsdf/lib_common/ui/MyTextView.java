package com.yhklsdf.lib_common.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yhklsdf.lib_common.app.BaseApplication;

public class MyTextView extends AppCompatTextView {


    public MyTextView(Context context) {
        super(context);
        // 设置下载好的字体
        setTypeface(BaseApplication.Companion.getTypeFace());
        // 去除默认padding
        setIncludeFontPadding(false);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 设置下载好的字体
        setTypeface(BaseApplication.Companion.getTypeFace());
        // 去除默认padding
        setIncludeFontPadding(false);
    }


    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 设置下载好的字体
        setTypeface(BaseApplication.Companion.getTypeFace());
        setIncludeFontPadding(false);
    }
}
