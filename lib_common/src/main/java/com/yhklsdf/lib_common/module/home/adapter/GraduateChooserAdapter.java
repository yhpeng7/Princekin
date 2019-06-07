package com.yhklsdf.lib_common.module.home.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.activity.PostGraduateActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GraduateChooserAdapter extends RecyclerView.Adapter<GraduateChooserAdapter.GraduateChooserViewHolder> {
    private List<String> mStringList;
    private PostGraduateActivity mActivity;
    private GraduateChooserViewHolder mSelectedViewHolder;
    private int mSelected = 0;

    public GraduateChooserAdapter(PostGraduateActivity activity, List<String> stringList) {
        this.mActivity = activity;
        this.mStringList = stringList;
    }

    public void setStringList(List<String> stringList) {
        this.mStringList = stringList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GraduateChooserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity)
                .inflate(R.layout.home_item_post_graduate_chooser, viewGroup, false);
        GraduateChooserViewHolder viewHolder = new GraduateChooserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GraduateChooserViewHolder graduateChooserViewHolder, int i) {
        graduateChooserViewHolder.home_txtv_post_graduate_chooser.setText(mStringList.get(i));
        if (mSelected == i) {
            onSelectedTab(graduateChooserViewHolder);
        } else {
            onDeSelectedTab(graduateChooserViewHolder);
        }
        graduateChooserViewHolder.home_constraint_post_graduate_chooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelected != i) {
                    mSelected = i;
                    getSchoolFromServer(mStringList.get(i));
                    onDeSelectedTab(mSelectedViewHolder);
                    onSelectedTab(graduateChooserViewHolder);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    private void onSelectedTab(GraduateChooserViewHolder viewHolder) {
        mSelectedViewHolder = viewHolder;
        viewHolder.home_constraint_post_graduate_chooser.setBackground(mActivity.getResources()   //设置颜色和字体
                .getDrawable(R.drawable.home_background_post_graduate_chooser));
        viewHolder.home_txtv_post_graduate_chooser.setTextColor(Color.WHITE);
    }

    private void onDeSelectedTab(GraduateChooserViewHolder viewHolder) {
        viewHolder.home_constraint_post_graduate_chooser.setBackground(null);
        viewHolder.home_txtv_post_graduate_chooser.setTextColor(Color.BLACK);
    }

    private void getSchoolFromServer(String temp) {
//                Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                        //通过网络请求获取相关学校信息;
//                        emitter.onNext("某个学校");
//                    }
//                });
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

    class GraduateChooserViewHolder extends RecyclerView.ViewHolder {
        TextView home_txtv_post_graduate_chooser;
        ConstraintLayout home_constraint_post_graduate_chooser;

        public GraduateChooserViewHolder(@NonNull View itemView) {
            super(itemView);
            home_txtv_post_graduate_chooser = itemView.findViewById(R.id.home_txtv_item_post_graduate_chooser);
            home_constraint_post_graduate_chooser = itemView.findViewById(R.id.home_constraint_item_post_graduate_chooser);

        }
    }
}
