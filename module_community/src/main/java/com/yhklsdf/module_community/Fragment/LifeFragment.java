package com.yhklsdf.module_community.Fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yhklsdf.module_community.R;

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

public class LifeFragment extends Fragment {
    private MagicIndicator com_magic_indicator_life;
    private ViewPager com_vpager_life;
    private List<Fragment> mFragmentList;
    private List<String> mStringList;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life, container, false);
        com_magic_indicator_life = view.findViewById(R.id.com_life_magic_indicator);
        com_vpager_life = view.findViewById(R.id.com_life_view_pager);
        mFragmentList = new ArrayList<>();
        LivingFragment livingFragment = new LivingFragment();
        RunFragment runFragment = new RunFragment();
        RentFragment rentFragment = new RentFragment();
        SecondeFragment secondeFragment = new SecondeFragment();
        WorkFragment workFragment = new WorkFragment();
        mFragmentList.add(livingFragment);
        mFragmentList.add(runFragment);
        mFragmentList.add(rentFragment);
        mFragmentList.add(secondeFragment);
        mFragmentList.add(workFragment);
        mStringList = new ArrayList<>();
        mStringList.add("生活");
        mStringList.add("跑腿");
        mStringList.add("租房");
        mStringList.add("二手");
        mStringList.add("兼职");
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem (int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount () {
                return mFragmentList.size();
            }
        };
        com_vpager_life.setAdapter(pagerAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount () {
                return mStringList.size();
            }

            @Override
            public IPagerTitleView getTitleView (Context context, int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(getResources().getColor(R.color.com_color_title));
                colorTransitionPagerTitleView.setSelectedColor(getResources().getColor(R.color.com_color_title));
                colorTransitionPagerTitleView.setText(mStringList.get(index));
                colorTransitionPagerTitleView.setTextSize(15);
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View view) {
                        com_vpager_life.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator (Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(getContext());
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineWidth(getResources().getDimension(R.dimen.com_indicator_life_width));
                indicator.setLineHeight(getResources().getDimension(R.dimen.com_indicator_life_height));
                indicator.setColors(getResources().getColor(R.color.com_color_life_indicator));
                indicator.setYOffset(16);
                return indicator;
            }
        });
        com_magic_indicator_life.setNavigator(commonNavigator);
        LinearLayout linearLayout = commonNavigator.getTitleContainer();
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(new ColorDrawable() {
            @Override
            public int getIntrinsicWidth () {
                return 50;
            }
        });
        ViewPagerHelper.bind(com_magic_indicator_life, com_vpager_life);
        return view;
    }
}
