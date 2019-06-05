package com.yhklsdf.module_course.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhklsdf.module_course.util.DensityUtil;
import com.yhklsdf.module_course.adapter.MyCourseAdapter;
import com.yhklsdf.module_course.view.MyCourseItemDecoration;
import com.yhklsdf.module_course.R;
import com.yhklsdf.module_course.data.MyCourse;

import java.util.ArrayList;
import java.util.List;

public class MyCourseFragment extends Fragment {
    private RecyclerView mCourseRecycler;
    private MyCourseAdapter mCourseAdapter;
    private List<MyCourse> mMyCourseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_course, container, false);
        mCourseRecycler = view.findViewById(R.id.rv_my_course);
        initData();
        mCourseAdapter = new MyCourseAdapter(getContext(), mMyCourseData, null);
        GridLayoutManager courseLayoutManager = new GridLayoutManager(getContext(), 2);
        mCourseRecycler.setAdapter(mCourseAdapter);
        mCourseRecycler.setLayoutManager(courseLayoutManager);
        int width = DensityUtil.dip2px(getContext(), 162);
        int spacing = view.getWidth() - 2 * width;
        mCourseRecycler.addItemDecoration(new MyCourseItemDecoration(2, 50, true));
        return view;
    }

    private void initData() {
        mMyCourseData = new ArrayList<>();

        MyCourse myCourse1 = new MyCourse();
        myCourse1.setCourseUrl(R.mipmap.couse2);
        myCourse1.setCourseName("JAVA");
        myCourse1.setCourseType("已购");
        myCourse1.setCouseProgress(9);
        mMyCourseData.add(myCourse1);
        mMyCourseData.add(myCourse1);
        mMyCourseData.add(myCourse1);

        MyCourse myCourse2 = new MyCourse();
        myCourse2.setCourseUrl(R.mipmap.couse4);
        myCourse2.setCouseProgress(56);
        myCourse2.setCourseName("python");
        myCourse2.setCourseType("已购");
        mMyCourseData.add(myCourse2);
        mMyCourseData.add(myCourse2);
        mMyCourseData.add(myCourse2);

        MyCourse myCourse3 = new MyCourse();
        myCourse3.setCourseUrl(R.mipmap.couse5);
        myCourse3.setCouseProgress(33);
        myCourse3.setCourseType("已购");
        myCourse3.setCourseName("UI视觉设计");
        mMyCourseData.add(myCourse3);
        mMyCourseData.add(myCourse3);
        mMyCourseData.add(myCourse3);
    }
}
