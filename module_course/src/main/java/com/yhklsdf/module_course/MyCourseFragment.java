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
        Course course = new Course();
        course.setCourseName("JAVA零基础从入门到精通");
        course.setType("付费");
        course.setJoinCount(3460);
        for (int i = 0; i < 9; i++) {
            mBuyCourseData.add(course);
        }
        StudyCourse studyCourse = new StudyCourse();
        studyCourse.setCourseName("JAVA零基础从入门到精通");
        studyCourse.setCouseProgress(56);
        for (int i = 0; i < 11; i++) {
            mStudyCourseData.add(studyCourse);
        }
    }
}
