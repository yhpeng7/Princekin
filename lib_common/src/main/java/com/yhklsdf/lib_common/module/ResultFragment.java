package com.yhklsdf.lib_common.module;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhklsdf.lib_common.R;

import java.util.List;

public class ResultFragment extends Fragment {
    private RecyclerView lib_recycler_search;
    private SearchAdapter mAdapter;
    private LinearLayoutManager mManager;
    private SearchActivity mSearchActivity;    //丑陋的回调
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lib_fragment_result, container, false);
        lib_recycler_search = view.findViewById(R.id.lib_recycler_result);
        mAdapter = new SearchAdapter(getActivity(), getContext());
        mManager = new LinearLayoutManager(getContext());
        lib_recycler_search.setAdapter(mAdapter);
        lib_recycler_search.setLayoutManager(mManager);
        mSearchActivity = (SearchActivity) getActivity();
        return view;
    }

    public void setResultData(List<String> resultList){ //将获取到的搜索结果设置到recyclerView
        mAdapter.setResultList(resultList);
    }

}
