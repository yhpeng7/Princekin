package com.yhklsdf.module_course;

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
import com.yhklsdf.module_course.data.StudyCourse;

import java.util.ArrayList;
import java.util.List;

public class MyCourseFragment extends Fragment {
    private RecyclerView mBuyCourse;
    private RecyclerView mMyCourse;
    private CourseAdapter mBuyCourseAdapter;
    private StudyCourseAdapter mMyCourseAdapter;
    private List<Course> mBuyCourseData;
    private List<StudyCourse> mStudyCourseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_course, container, false);
        mBuyCourse = view.findViewById(R.id.buy_course_recyclerview);
        mMyCourse = view.findViewById(R.id.study_course_recyclerview);
        initData();
        mBuyCourseAdapter = new CourseAdapter(getContext(), mBuyCourseData, null);
        mMyCourseAdapter = new StudyCourseAdapter(getContext(), mStudyCourseData, null);
        StaggeredGridLayoutManager hotCourseLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager recommendCourseLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mBuyCourse.setLayoutManager(hotCourseLayoutManager);
        mBuyCourse.setAdapter(mBuyCourseAdapter);
        mMyCourse.setAdapter(mMyCourseAdapter);
        mMyCourse.setLayoutManager(recommendCourseLayoutManager);
        return view;
    }

    private void initData() {
        mBuyCourseData = new ArrayList<>();
        mStudyCourseData = new ArrayList<>();
        Course course1 = new Course();
        course1.setCourseImgUrl(R.mipmap.couse2);
        course1.setCourseName("JAVA零基础从入门到精通");
        course1.setType("付费");
        course1.setJoinCount(3460);
        mBuyCourseData.add(course1);

        Course course2 = new Course();
        course2.setCourseImgUrl(R.mipmap.couse4);
        course2.setCourseName("Python基础课程");
        course2.setType("付费");
        course2.setJoinCount(3390);
        mBuyCourseData.add(course2);

        Course course3 = new Course();
        course3.setJoinCount(2345);
        course3.setCourseImgUrl(R.mipmap.couse5);
        course3.setCourseName("UI视觉设计");
        course3.setType("付费");
        mBuyCourseData.add(course3);

        StudyCourse studyCourse1 = new StudyCourse();
        studyCourse1.setCourseUrl(R.mipmap.couse2);
        studyCourse1.setCouseProgress(9);
        mStudyCourseData.add(studyCourse1);

        StudyCourse studyCourse2 = new StudyCourse();
        studyCourse2.setCourseUrl(R.mipmap.couse4);
        studyCourse2.setCouseProgress(56);
        mStudyCourseData.add(studyCourse2);

        StudyCourse studyCourse3 = new StudyCourse();
        studyCourse3.setCourseUrl(R.mipmap.couse5);
        studyCourse3.setCouseProgress(33);
        mStudyCourseData.add(studyCourse3);
    }
}
