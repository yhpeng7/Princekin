package com.yhklsdf.module_course;

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

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

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
        mTitles.add("所有课程");
        mTitles.add("我的课程");
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
                ColorTransitionPagerTitleView titleView = new ColorTransitionPagerTitleView(getContext());
                titleView.setText(mTitles.get(index));
                titleView.setNormalColor(Color.parseColor("#000000"));
                titleView.setSelectedColor(Color.parseColor("#000000"));
                titleView.setTextSize(16);
                titleView.setOnClickListener((v -> mViewPager.setCurrentItem(index)));
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(getContext());
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineWidth(getResources().getDimension(R.dimen.indicator_width));
                indicator.setLineHeight(getResources().getDimension(R.dimen.indicator_height));
                indicator.setYOffset(55);
                indicator.setColors(Color.parseColor("#569BD8"));
                return indicator;
            }
        });
        mTabLayout.setNavigator(navigator);
        ViewPagerHelper.bind(mTabLayout, mViewPager);
        return view;
    }
}
