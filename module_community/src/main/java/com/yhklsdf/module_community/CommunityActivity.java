package com.yhklsdf.module_community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yhklsdf.module_community.Fragment.CommunityFragment;

import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends AppCompatActivity {
    ViewPager com_test_viewpager;
    List<Fragment> fragmentList;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_activity_community);
        com_test_viewpager = findViewById(R.id.com_test_viewpager);
        CommunityFragment communityFragment = new CommunityFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(communityFragment);
        com_test_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem (int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount () {
                return fragmentList.size();
            }
        });

    }
}
