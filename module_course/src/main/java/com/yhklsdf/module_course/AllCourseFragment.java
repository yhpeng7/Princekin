package com.yhklsdf.module_course;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhklsdf.module_course.data.Course;

import java.util.ArrayList;
import java.util.List;

public class AllCourseFragment extends Fragment {
    private RecyclerView mHotCourse;
    private RecyclerView mRecommendCourse;
    private CourseAdapter mHotCourseAdapter;
    private CourseAdapter mRecommendCourseAdapter;
    private List<Course> mHotCourseData;
    private List<Course> mRecommendCourseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_course, container, false);
        mHotCourse = view.findViewById(R.id.hot_course_recyclerview);
        mRecommendCourse = view.findViewById(R.id.recommend_course_recyclerview);
        initData();
        mHotCourseAdapter = new CourseAdapter(getContext(), mHotCourseData, null);
        mRecommendCourseAdapter = new CourseAdapter(getContext(), mRecommendCourseData, null);
        StaggeredGridLayoutManager hotCourseLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager recommendCourseLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mHotCourse.setLayoutManager(hotCourseLayoutManager);
        mHotCourse.setAdapter(mHotCourseAdapter);
        mRecommendCourse.setAdapter(mRecommendCourseAdapter);
        mRecommendCourse.setLayoutManager(recommendCourseLayoutManager);
        return view;
    }

    private void initData() {
        mHotCourseData = new ArrayList<>();
        mRecommendCourseData = new ArrayList<>();
        Course course1 = new Course();
        course1.setCourseImgUrl(R.mipmap.couse2);
        course1.setCourseName("JAVA零基础从入门到精通");
        course1.setType("免费");
        course1.setJoinCount(3460);
        mHotCourseData.add(course1);

        Course course2 = new Course();
        course2.setCourseImgUrl(R.mipmap.couse4);
        course2.setCourseName("Python基础课程");
        course2.setType("免费");
        course2.setJoinCount(3390);
        mHotCourseData.add(course2);

        Course course3 = new Course();
        course3.setJoinCount(2345);
        course3.setCourseImgUrl(R.mipmap.couse5);
        course3.setCourseName("UI视觉设计");
        course3.setType("免费");
        mHotCourseData.add(course3);

        Course course4 = new Course();
        course4.setJoinCount(4366);
        course4.setCourseImgUrl(R.mipmap.couse6);
        course4.setCourseName("大数据");
        course4.setType("免费");
        mHotCourseData.add(course4);

        Course course5 = new Course();
        course5.setJoinCount(5234);
        course5.setCourseImgUrl(R.mipmap.couse1);
        course5.setCourseName("Linux C语言");
        course5.setType("限免");
        mHotCourseData.add(course5);

        Course course6 = new Course();
        course6.setJoinCount(2345);
        course6.setCourseImgUrl(R.mipmap.couse3);
        course6.setCourseName("平面设计");
        course6.setType("付费");
        mHotCourseData.add(course6);

        Course course7 = new Course();
        course7.setCourseName("JAVA");
        course7.setJoinCount(3460);
        course7.setType("精品付费");
        course7.setCourseImgUrl(R.mipmap.couse7);
        mRecommendCourseData.add(course7);

        Course course8 = new Course();
        course8.setCourseName("C++");
        course8.setJoinCount(3460);
        course8.setType("精品付费");
        course8.setCourseImgUrl(R.mipmap.couse8);
        mRecommendCourseData.add(course8);

        Course course9 = new Course();
        course9.setCourseName("C语言");
        course9.setJoinCount(3460);
        course9.setType("精品付费");
        course9.setCourseImgUrl(R.mipmap.couse9);
        mRecommendCourseData.add(course9);
    }
}
