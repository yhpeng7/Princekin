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
import com.yhklsdf.module_community.com_Constant;

import java.util.ArrayList;
import java.util.List;

public class SecondeFragment extends Fragment implements com_Constant {
    private RecyclerView com_recycler_view_seconde;
    private List<LifeBean> lifeBeanList;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life_seconde,container,false);
        com_recycler_view_seconde = view.findViewById(R.id.com_recycler_life_seconde);
        lifeBeanList = new ArrayList<>();
        LifeBean lifeBean = new LifeBean("1",
                "江流儿",
                "出一款刚到手的小米九，全新。不解释为什么，因为小米十快出了",
                "09.12",
                "869",
                "12",TEXT);
        for(int i = 0;i<10;i++){
            lifeBeanList.add(lifeBean);
        }
        LifeAdapter lifeAdapter = new LifeAdapter(getContext(),lifeBeanList,SECONDE);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        com_recycler_view_seconde.setAdapter(lifeAdapter);
        com_recycler_view_seconde.setLayoutManager(manager);
//        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(30);
//        com_recycler_view_seconde.addItemDecoration(spaceItemDecoration);
        return view;
    }
}
