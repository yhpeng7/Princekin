package com.yhklsdf.module_course.view;

import android.content.Context;

import com.yhklsdf.module_course.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class CourseTypeTitleView extends SimplePagerTitleView {
    public CourseTypeTitleView(Context context) {
        super(context);
    }

    @Override
    public void onSelected(int index, int totalCount) {
        super.onSelected(index, totalCount);
        setBackgroundResource(R.drawable.bg_course_type_selected);
    }

    @Override
    public void onDeselected(int index, int totalCount) {
        super.onDeselected(index, totalCount);
        setBackgroundResource(R.drawable.bg_course_type_normal);
    }
}
