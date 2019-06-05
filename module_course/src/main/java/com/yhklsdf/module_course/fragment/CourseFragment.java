package com.yhklsdf.module_course.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yhklsdf.lib_common.app.BaseApplication;
import com.yhklsdf.module_course.view.CourseFragmentTitleView;
import com.yhklsdf.module_course.view.MyIndicator;
import com.yhklsdf.module_course.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/course/main")
public class CourseFragment extends Fragment {
    private MagicIndicator mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        mTabLayout = view.findViewById(R.id.course_tablayout);
        mViewPager = view.findViewById(R.id.course_viewpager);
        Fragment allCourseFragment = new AllCourseFragment();
        Fragment recommendCourseFragment = new MyCourseFragment();
        mFragments.add(allCourseFragment);
        mFragments.add(recommendCourseFragment);
        mTitles.add("全部");
        mTitles.add("我的");
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        CommonNavigator navigator = new CommonNavigator(getContext());
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                CourseFragmentTitleView titleView = new CourseFragmentTitleView(getContext());
                titleView.setText(mTitles.get(index));
                titleView.setNormalColor(Color.parseColor("#F7FBFF"));
                titleView.setSelectedColor(Color.parseColor("#F7FBFF"));
                titleView.setTextSize(16);
                titleView.setTypeface(BaseApplication.Companion.getTypeFace());
                titleView.setIncludeFontPadding(false);
                titleView.setOnClickListener((v -> mViewPager.setCurrentItem(index)));
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                MyIndicator indicator = new MyIndicator(getContext());
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 6));
                indicator.setLineWidth(UIUtil.dip2px(context, 17));
                indicator.setYOffset(UIUtil.dip2px(context,12));
                return indicator;
            }
        });
        mTabLayout.setNavigator(navigator);
        ViewPagerHelper.bind(mTabLayout, mViewPager);
        return view;
    }
}
