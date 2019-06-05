package com.yhklsdf.module_community.Fragment;

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
import com.yhklsdf.module_community.Item.MyIndicator;
import com.yhklsdf.module_community.Item.MyPagerTitleView;
import com.yhklsdf.module_community.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/community/fragment")
public class CommunityFragment extends Fragment {
    private List<Fragment> mFragmentList;
    private List<String> mStringList;
    private ViewPager com_viewpager;
    private MagicIndicator com_magic_indicator;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_community,container,false);
        com_viewpager = view.findViewById(R.id.com_vpager_main);
        com_magic_indicator = view.findViewById(R.id.com_mgc_indicator_main);
        TechFragment techFragment = new TechFragment();
        LifeFragment lifeFragment = new LifeFragment();
        mFragmentList = new ArrayList<>();
        mStringList = new ArrayList<>();
        mFragmentList.add(techFragment);
        mFragmentList.add(lifeFragment);
        mStringList.add("技术区");
        mStringList.add("生活区");
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem (int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount () {
                return mFragmentList.size();
            }

        };
        com_viewpager.setAdapter(fragmentPagerAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount () {
                return mStringList.size();
            }

            @Override
            public IPagerTitleView getTitleView (Context context, int index) {
                MyPagerTitleView myPagerTitleView = new MyPagerTitleView(context);
                myPagerTitleView.setNormalColor(getResources().getColor(R.color.com_color_magc_indicator_text));
                myPagerTitleView.setSelectedColor(getResources().getColor(R.color.com_color_magc_indicator_text));
                myPagerTitleView.setText(mStringList.get(index));
                myPagerTitleView.setTextSize(18);   //这一位为了测量的时候留够空间所以设置成俩最大的大小
                myPagerTitleView.setSelectedTextSize(18);   //设置选中放大
                myPagerTitleView.setNormalTextSize(15);     //设置离开缩小
                myPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View view) {
                        com_viewpager.setCurrentItem(index);
                    }
                });
                return myPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator (Context context) {
                MyIndicator indicator = new MyIndicator(context);
                indicator.setMode(MyIndicator.MODE_EXACTLY);
                indicator.setYOffset(UIUtil.dip2px(context,14));
                return indicator;
            }
        });
        com_magic_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(com_magic_indicator, com_viewpager);
        return view;
    }
}
