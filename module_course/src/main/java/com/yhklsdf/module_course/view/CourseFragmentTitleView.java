package com.yhklsdf.module_course.view;

import android.content.Context;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class CourseFragmentTitleView extends SimplePagerTitleView {
    private int mSelectedBGColor;
    private int mNormalBGColor;
    public CourseFragmentTitleView(Context context) {
        super(context);
    }

    @Override
    public void onSelected(int index, int totalCount) {
        super.onSelected(index, totalCount);
        setTextSize(18);
    }

    @Override
    public void onDeselected(int index, int totalCount) {
        super.onDeselected(index, totalCount);
        setTextSize(15);
    }

    public int getSelectedBGColor() {
        return mSelectedBGColor;
    }

    public void setSelectedBGColor(int selectedBGColor) {
        mSelectedBGColor = selectedBGColor;
    }

    public int getNormalBGColor() {
        return mNormalBGColor;
    }

    public void setNormalBGColor(int normalBGColor) {
        mNormalBGColor = normalBGColor;
    }
}
