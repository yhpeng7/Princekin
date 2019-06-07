package com.yhklsdf.module_home.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhklsdf.module_home.R;
import com.yhklsdf.module_home.adapter.MessageAdapter;
import com.yhklsdf.module_home.adapter.RankingAdapter;
import com.yhklsdf.module_home.bean.MessageBean;
import com.yhklsdf.module_home.bean.RankingBean;

import java.util.ArrayList;
import java.util.List;

public class HonorFragment extends Fragment {

    private List<RankingBean> mRankingList;
    private List<MessageBean> mMessageList;
    private RecyclerView mRankingRecycler;
    private RecyclerView mMessageRecycler;
    private RankingAdapter mRankingAdapter;
    private MessageAdapter mMessageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.h_fragment_honor, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        mRankingList = new ArrayList<>();
        mMessageList = new ArrayList<>();
        RankingBean honorBean = new RankingBean("张三", "计算机院", 1280,
                "就业", "阿里", "50万");
        MessageBean messageBean = new MessageBean("张三", "计算机院",
                "就业", "阿里", "50万",
                "张三，于2019年正式与阿里巴巴签约，年薪50万");
        for (int i = 0; i < 10; i++) {
            mRankingList.add(honorBean);
            mMessageList.add(messageBean);
        }
    }

    private void initView(View view) {
        mRankingRecycler = view.findViewById(R.id.h_rv_ranking);
        mMessageRecycler = view.findViewById(R.id.h_rv_message);
        mRankingAdapter = new RankingAdapter(mRankingList);
        mRankingRecycler.setAdapter(mRankingAdapter);
        mRankingRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mMessageAdapter = new MessageAdapter(mMessageList);
        mMessageRecycler.setAdapter(mMessageAdapter);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
