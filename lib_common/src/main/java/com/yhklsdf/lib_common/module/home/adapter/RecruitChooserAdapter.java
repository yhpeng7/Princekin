package com.yhklsdf.lib_common.module.home.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.activity.RecruitActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RecruitChooserAdapter extends RecyclerView.Adapter<RecruitChooserAdapter.RecruitChooserViewHolder> {
    private RecruitActivity mActivity;
    private List<String> mStringList;

    public RecruitChooserAdapter(RecruitActivity activity, List<String> stringList) {
        this.mActivity = activity;
        this.mStringList = stringList;
    }

    public void setStringList(List<String> stringList) {
        this.mStringList = stringList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecruitChooserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.home_item_recruit_chooser, viewGroup, false);
        RecruitChooserViewHolder viewHolder = new RecruitChooserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecruitChooserViewHolder recruitChooserViewHolder, int i) {
        recruitChooserViewHolder.home_txtv_item_recruit_chooser.setText(mStringList.get(i));
        if (mActivity.getSelectedViewHolder() == null) {
            onSelectedTab(recruitChooserViewHolder);
        } else {
            onDeSelectedTab(recruitChooserViewHolder);
        }
        recruitChooserViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActivity.getSelectedViewHolder() != recruitChooserViewHolder) {
                    getCareerFromServer(mStringList.get(i));
                    onDeSelectedTab(mActivity.getSelectedViewHolder());
                    onSelectedTab(recruitChooserViewHolder);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    private void getCareerFromServer(String temp) {
        mActivity.setCurtainVisibility(View.VISIBLE);
        Observable.interval(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        mActivity.setCurtainVisibility(View.GONE);
                    }
                });
    }

    private void onSelectedTab(RecruitChooserViewHolder viewHolder) {
        viewHolder.itemView.setBackground(mActivity.getResources()   //设置颜色和字体
                .getDrawable(R.drawable.home_background_recruit_chooser));
        viewHolder.home_txtv_item_recruit_chooser.setTextColor(Color.WHITE);
        mActivity.setSelectedViewHolder(viewHolder);
    }

    private void onDeSelectedTab(RecruitChooserViewHolder viewHolder) {
        viewHolder.itemView.setBackground(null);
        viewHolder.home_txtv_item_recruit_chooser.setTextColor(Color.BLACK);
    }


    public class RecruitChooserViewHolder extends RecyclerView.ViewHolder {
        private TextView home_txtv_item_recruit_chooser;

        public RecruitChooserViewHolder(@NonNull View itemView) {
            super(itemView);
            home_txtv_item_recruit_chooser = itemView.findViewById(R.id.home_txtv_item_recruit_chooser);
        }
    }
}
