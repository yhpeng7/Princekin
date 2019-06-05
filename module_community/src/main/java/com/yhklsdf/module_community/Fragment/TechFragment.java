package com.yhklsdf.module_community.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhklsdf.module_community.DataBean;
import com.yhklsdf.module_community.R;
import com.yhklsdf.module_community.TechAdapter;

import java.util.ArrayList;

public class TechFragment extends Fragment {
    RecyclerView com_tech_recyclerview;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_tech, container, false);
        com_tech_recyclerview = view.findViewById(R.id.com_recycler_tech);
        ArrayList<DataBean> dataBeanList = new ArrayList<>();
        DataBean dataBean1 = new DataBean("1", "千与千寻", "电子工程学院", "java|如何写出一套让手机壳变色的程序", "叶志峰,杨...18人回答了此问题", "刚刚");
        DataBean dataBean2 = new DataBean("2", "蔡徐坤", "电子信息学院", "AE|如何打造华丽的后期持续性艳丽", "叶志峰,杨...18人回答了此问题", "05:12");
        DataBean dataBean3 = new DataBean("3", "花小妹", "通信与工程学院", "嵌入式开发|单片机怎么做,求帮助", "叶志峰,杨...18人回答了此问题", "2019.4.14");
        DataBean dataBean4 = new DataBean("4", "龙苏代", "机械与自动化学院", "C语言|我是怎么从一个小白到大神的", "叶志峰,杨...18人回答了此问题", "2019.4.13");
        DataBean dataBean5 = new DataBean("5", "大明哥", "计算机学院", "pathon|怎么系统地学习这门语言", "叶志峰,杨...18人回答了此问题", "2019.4.12");
        for (int i = 0; i < 3; i++) {
            dataBeanList.add(dataBean1);
            dataBeanList.add(dataBean2);
            dataBeanList.add(dataBean3);
            dataBeanList.add(dataBean4);
            dataBeanList.add(dataBean5);
        }
        TechAdapter techAdapter = new TechAdapter(getContext(), dataBeanList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        com_tech_recyclerview.setAdapter(techAdapter);
        com_tech_recyclerview.setLayoutManager(linearLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.com_recycler_divider));
        com_tech_recyclerview.addItemDecoration(divider);
        return view;
    }
}
