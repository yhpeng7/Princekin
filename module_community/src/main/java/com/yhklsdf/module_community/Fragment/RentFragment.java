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

public class RentFragment extends Fragment implements com_Constant {
    private RecyclerView com_recycler_view_rent;
    private List<LifeBean> lifeBeanList;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life_rent,container,false);
        com_recycler_view_rent = view.findViewById(R.id.com_recycler_life_rent);
        lifeBeanList = new ArrayList<>();
        LifeBean lifeBean = new LifeBean("1",
                "马不可",
                "出租一套春天花园的居民房，一室二厅三卧，有意联系我:13678943839",
                "09.12",
                "869",
                "12",TEXT);
        for(int i = 0;i<10;i++){
            lifeBeanList.add(lifeBean);
        }
        LifeAdapter lifeAdapter = new LifeAdapter(getContext(),lifeBeanList,RENT);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        com_recycler_view_rent.setAdapter(lifeAdapter);
        com_recycler_view_rent.setLayoutManager(manager);
//        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(30);
//        com_recycler_view_rent.addItemDecoration(spaceItemDecoration);
        return view;
    }
}
