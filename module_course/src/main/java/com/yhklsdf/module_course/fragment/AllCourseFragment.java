package com.yhklsdf.module_course.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yhklsdf.lib_common.app.BaseApplication;
import com.yhklsdf.module_course.view.AllCourseItemDecoration;
import com.yhklsdf.module_course.adapter.AllCourseAdapter;
import com.yhklsdf.module_course.view.CourseTypeTitleView;
import com.yhklsdf.module_course.R;
import com.yhklsdf.module_course.data.Course;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import kotlin.reflect.KAnnotatedElement;

public class AllCourseFragment extends Fragment {
    private RecyclerView mCourseRecycler;
    private AllCourseAdapter mCourseAdapter;
    private MagicIndicator mTabLayout;
    private List<String> mTitles;
    private List<Course> mCourseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_course, container, false);
        mCourseRecycler = view.findViewById(R.id.rl_course);
        mTabLayout = view.findViewById(R.id.tab_layout_course);
        initData();
        mCourseAdapter = new AllCourseAdapter(getContext(), mCourseData, null);
        StaggeredGridLayoutManager courseLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mCourseRecycler.setLayoutManager(courseLayoutManager);
        mCourseRecycler.setAdapter(mCourseAdapter);
        mCourseRecycler.addItemDecoration(new AllCourseItemDecoration(2, 50, true));
        CommonNavigator navigator = new CommonNavigator(getContext());
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                CourseTypeTitleView titleView = new CourseTypeTitleView(getContext());
                titleView.setText(mTitles.get(index));
                titleView.setSelectedColor(Color.parseColor("#5195d2"));
                titleView.setNormalColor(Color.parseColor("#000000"));
                titleView.setTextSize(12);
                titleView.setTypeface(BaseApplication.Companion.getTypeFace());
                // 去除默认padding
                titleView.setIncludeFontPadding(false);
                titleView.setOnClickListener(v -> updateData(index));
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        mTabLayout.setNavigator(navigator);
        return view;
    }

    private void updateData(int index) {
        mTabLayout.onPageSelected(index);
    }

    private void initData() {
        mCourseData = new ArrayList<>();
        Course course1 = new Course();
        course1.setCourseImgUrl(R.mipmap.couse2);
        course1.setCourseName("JAVA零基础从入门到精通");
        course1.setType("免费");
        mCourseData.add(course1);
        mCourseData.add(course1);
        mCourseData.add(course1);

        Course course2 = new Course();
        course2.setCourseImgUrl(R.mipmap.couse4);
        course2.setCourseName("Python基础课程");
        course2.setType("免费");
        mCourseData.add(course2);
        mCourseData.add(course2);
        mCourseData.add(course2);

        Course course3 = new Course();
        course3.setCourseImgUrl(R.mipmap.couse5);
        course3.setCourseName("UI视觉设计");
        course3.setType("免费");
        mCourseData.add(course3);
        mCourseData.add(course3);
        mCourseData.add(course3);

        Course course4 = new Course();
        course4.setCourseImgUrl(R.mipmap.couse6);
        course4.setCourseName("大数据");
        course4.setType("免费");
        mCourseData.add(course4);
        mCourseData.add(course4);
        mCourseData.add(course4);

        Course course5 = new Course();
        course5.setCourseImgUrl(R.mipmap.couse1);
        course5.setCourseName("Linux C语言");
        course5.setType("限免");
        mCourseData.add(course5);
        mCourseData.add(course5);
        mCourseData.add(course5);

        Course course6 = new Course();
        course6.setCourseImgUrl(R.mipmap.couse3);
        course6.setCourseName("平面设计");
        course6.setType("付费");
        mCourseData.add(course6);
        mCourseData.add(course6);
        mCourseData.add(course6);

        mTitles = new ArrayList<>();
        mTitles.add("推荐");
        mTitles.add("前端开发");
        mTitles.add("Java");
        mTitles.add("后台开发");
        mTitles.add("android开发");
        mTitles.add("ios开发");
        mTitles.add("嵌入式开发");
        mTitles.add("大数据");
        mTitles.add("人工智能");
        mTitles.add("区块链");
    }
}
