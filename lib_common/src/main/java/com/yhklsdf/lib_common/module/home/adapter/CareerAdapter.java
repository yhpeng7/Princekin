package com.yhklsdf.lib_common.module.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.activity.RecruitActivity;
import com.yhklsdf.lib_common.module.home.item.CareerBean;

import java.util.List;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.CareerViewHolder> {
    private List<CareerBean> mCareerBeanList;
    private RecruitActivity mActivity;

    public CareerAdapter(RecruitActivity activity, List<CareerBean> careerBeanList) {
        this.mActivity = activity;
        this.mCareerBeanList = careerBeanList;
    }

    public void setCareerBeanList(List<CareerBean> careerBeanList) {
        this.mCareerBeanList = careerBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CareerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.home_item_recruit_career, viewGroup, false);
        CareerViewHolder viewHolder = new CareerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CareerViewHolder careerViewHolder, int i) {
        CareerBean bean = mCareerBeanList.get(i);
        careerViewHolder.home_txtv_item_recruit_career_name.setText(bean.name);
        careerViewHolder.home_txtv_item_recruit_career_company.setText(bean.company_name);
        careerViewHolder.home_txtv_item_recruit_career_major.setText(bean.major);
        careerViewHolder.home_txtv_item_recruit_career_time.setText(bean.time);
        careerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "跳转", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCareerBeanList.size();
    }

    class CareerViewHolder extends RecyclerView.ViewHolder {
        private TextView home_txtv_item_recruit_career_name;
        private TextView home_txtv_item_recruit_career_company;
        private TextView home_txtv_item_recruit_career_major;
        private TextView home_txtv_item_recruit_career_time;

        public CareerViewHolder(@NonNull View itemView) {
            super(itemView);
            home_txtv_item_recruit_career_name = itemView.findViewById(R.id.home_txtv_item_recruit_career_name);
            home_txtv_item_recruit_career_company = itemView.findViewById(R.id.home_txtv_item_recruit_career_company);
            home_txtv_item_recruit_career_major = itemView.findViewById(R.id.home_txtv_item_recruit_career_major);
            home_txtv_item_recruit_career_time = itemView.findViewById(R.id.home_txtv_item_recruit_career_time);
        }
    }
}
