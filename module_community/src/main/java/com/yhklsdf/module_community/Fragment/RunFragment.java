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

public class RunFragment extends Fragment implements com_Constant {
    private RecyclerView com_recycler_view_Run;
    private List<LifeBean> lifeBeanList;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life_run,container,false);
        com_recycler_view_Run = view.findViewById(R.id.com_recycler_life_run);
        lifeBeanList = new ArrayList<>();
        LifeBean lifeBean = new LifeBean("1",
                "江流儿",
                "求帮忙带份饭来宿舍，有酬劳，请联系电话：13456445544",
                "09.12",
                "869",
                "12",TEXT);
        for(int i = 0;i<10;i++){
            lifeBeanList.add(lifeBean);
        }
        LifeAdapter lifeAdapter = new LifeAdapter(getContext(),lifeBeanList,RUN);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        com_recycler_view_Run.setAdapter(lifeAdapter);
        com_recycler_view_Run.setLayoutManager(manager);
//        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(30);
//        com_recycler_view_Run.addItemDecoration(spaceItemDecoration);
        return view;
    }
}
