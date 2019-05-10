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
        Course course = new Course();
        course.setCourseName("JAVA零基础从入门到精通");
        course.setType("免费");
        course.setJoinCount(3460);
        for (int i=0; i<9; i++) {
            mHotCourseData.add(course);
        }
        Course course1 = new Course();
        course1.setCourseName("JAVA零基础从入门到精通");
        course1.setType("免费");
        course1.setJoinCount(3460);
        course1.setType("精品付费");
        for (int i=0; i<9; i++) {
            mRecommendCourseData.add(course1);
        }
    }
}
