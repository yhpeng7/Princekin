package com.yhklsdf.lib_common.module.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.activity.RecruitActivity;
import com.yhklsdf.lib_common.module.home.item.CompanyBean;

import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private List<CompanyBean> mCompanyBeanList;
    private RecruitActivity mActivity;
    public CompanyAdapter(RecruitActivity activity,List<CompanyBean> companyBeanList){
        this.mActivity = activity;
        this.mCompanyBeanList = companyBeanList;
    }

    public void setmCompanyBeanList(List<CompanyBean> companyBeanList){
        this.mCompanyBeanList = companyBeanList;
        notifyDataSetChanged();;
    }
    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.home_item_recruit_company,viewGroup,false);
        CompanyViewHolder viewHolder = new CompanyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder companyViewHolder, int i) {
        CompanyBean bean = mCompanyBeanList.get(i);
        companyViewHolder.home_txtv_item_recruit_company_tag.setText(bean.tag);
        companyViewHolder.home_txtv_item_recruit_company_name.setText(bean.name);
        switch (bean.image){
            case "1":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_company_1))
                        .apply(RequestOptions.centerCropTransform()).into(companyViewHolder.home_imgv_item_recruit_company);
                break;
            case "2":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_company_2))
                        .apply(RequestOptions.centerCropTransform()).into(companyViewHolder.home_imgv_item_recruit_company);
                break;
            case "3":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_company_3))
                        .apply(RequestOptions.centerCropTransform()).into(companyViewHolder.home_imgv_item_recruit_company);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mCompanyBeanList.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_imgv_item_recruit_company;
        private TextView home_txtv_item_recruit_company_name;
        private TextView home_txtv_item_recruit_company_tag;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            home_imgv_item_recruit_company = itemView.findViewById(R.id.home_imgv_item_recruit_company);
            home_txtv_item_recruit_company_name = itemView.findViewById(R.id.home_txtv_item_recruit_company_name);
            home_txtv_item_recruit_company_tag = itemView.findViewById(R.id.home_txtv_item_recruit_company_tag);
        }
    }
}
