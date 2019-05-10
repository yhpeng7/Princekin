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

public class LivingFragment extends Fragment implements com_Constant {
    private RecyclerView com_recycler_view_living;
    private List<LifeBean> lifeBeanList;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.com_fragment_life_living,container,false);
        com_recycler_view_living = view.findViewById(R.id.com_recycler_life_living);
        lifeBeanList = new ArrayList<>();
        LifeBean lifeBean1 = new LifeBean("1",
                "悟空",
                "通院那个杨老师贼厉害，有人有他的联系方式嘛，跪舔一波",
                "刚刚",
                "1293",
                "145",
                TEXT);
        LifeBean lifeBean2 = new LifeBean("2",
                "八戒",
                "打卡一百七十三天，我将继续C语言的学习，知道拿到计算机二级证书！",
                "14:20",
                "680",
                "34",
                TEXT);
        LifeBean lifeBean3 = new LifeBean("3",
                "唐生",
                "又换了一套好看的衣服了，百看不腻，可惜没有小哥哥嘤嘤嘤",
                "14:20",
                "1293",
                "145",
                PHOTO);
        for(int i = 0;i<5;i++){
            lifeBeanList.add(lifeBean1);
            lifeBeanList.add(lifeBean2);
            lifeBeanList.add(lifeBean3);

        }
        LifeAdapter lifeAdapter = new LifeAdapter(getContext(),lifeBeanList,LIVING);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        com_recycler_view_living.setAdapter(lifeAdapter);
        com_recycler_view_living.setLayoutManager(manager);
//        SpaceItemDecoration spaceItemDecoration = new SpaceItemDecoration(30);
//        com_recycler_view_living.addItemDecoration(spaceItemDecoration);
        return view;
    }
}
