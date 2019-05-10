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

import com.yhklsdf.module_community.LifeAdapter;
import com.yhklsdf.module_community.LifeBean;
import com.yhklsdf.module_community.R;

import java.util.ArrayList;
import java.util.List;

import static com.yhklsdf.module_community.com_Constant.TEXT;
import static com.yhklsdf.module_community.com_Constant.WORK;

public class WorkFragment extends Fragment {
    private RecyclerView com_recycler_view_work;
    private List<LifeBean> lifeBeanList;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life_work,container,false);
        com_recycler_view_work = view.findViewById(R.id.com_recycler_life_work);
        lifeBeanList = new ArrayList<>();
        LifeBean lifeBean = new LifeBean("2",
                "关琪儿",
                "西安大学生马拉松急需兼职人员五百名，工资为一百一天，待会优渥，有意请联系",
                "04-12",
                "245",
                "68",TEXT);
        for(int i = 0;i<10;i++){
            lifeBeanList.add(lifeBean);
        }
        LifeAdapter lifeAdapter = new LifeAdapter(getContext(),lifeBeanList,WORK);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        com_recycler_view_work.setAdapter(lifeAdapter);
        com_recycler_view_work.setLayoutManager(manager);
//        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(30);
//        com_recycler_view_work.addItemDecoration(spaceItemDecoration);
        return view;
    }
}
