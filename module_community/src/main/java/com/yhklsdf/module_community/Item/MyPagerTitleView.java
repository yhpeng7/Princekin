package com.yhklsdf.module_community.Item;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class MyPagerTitleView extends SimplePagerTitleView {
    private float mSelectedTextSize;
    private float mNormalTextSize;

    public MyPagerTitleView(Context context) {
        super(context);
    }


    public float getNormalTextSize() {
        return mNormalTextSize;
    }

    public void setNormalTextSize(float mNormalTextSize) {
        this.mNormalTextSize = mNormalTextSize;
    }

    public float getSelectedTextSize() {
        return mSelectedTextSize;
    }

    public void setSelectedTextSize(float selectedTextSize) {
        mSelectedTextSize = selectedTextSize;
    }

    @Override
    public void onSelected(int index, int totalCount) {
        super.onSelected(index, totalCount);
        setTextSize(mSelectedTextSize);
        invalidate();
    }

    @Override
    public void onDeselected(int index, int totalCount) {
        super.onDeselected(index, Color.GRAY);
        setTextSize(mNormalTextSize);
    }
}
