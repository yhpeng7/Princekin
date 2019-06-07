package com.yhklsdf.lib_common.module.home.adapter;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yhklsdf.lib_common.R;
import com.yhklsdf.lib_common.module.home.item.SchoolBean;
import com.yhklsdf.lib_common.module.home.activity.PostGraduateActivity;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {
    private PostGraduateActivity mActivity;
    private List<SchoolBean> mSchoolBeanList;


    public SchoolAdapter(PostGraduateActivity activity, List<SchoolBean> schoolBeanList) {
        this.mActivity = activity;
        this.mSchoolBeanList = schoolBeanList;
    }

    public void setStringList(List<SchoolBean> schoolBeanList) {
        this.mSchoolBeanList = schoolBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.home_item_post_graduate_school, viewGroup, false);
        SchoolViewHolder viewHolder = new SchoolViewHolder(view);
        return viewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder viewHolder, int i) {
        SchoolBean bean = mSchoolBeanList.get(i);
        switch (bean.image){
            case "1":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_college_1, null))
                        .apply(RequestOptions.centerCropTransform())
                        .into(viewHolder.home_imgv_item_post_graduate_school);
                break;
            case "2":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_college_2, null))
                        .apply(RequestOptions.centerCropTransform())
                        .into(viewHolder.home_imgv_item_post_graduate_school);
                break;
            case "3":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_college_3, null))
                        .apply(RequestOptions.centerCropTransform())
                        .into(viewHolder.home_imgv_item_post_graduate_school);
                break;
            case "4":
                Glide.with(mActivity).load(mActivity.getResources().getDrawable(R.drawable.home_ic_college_4, null))
                        .apply(RequestOptions.centerCropTransform())
                        .into(viewHolder.home_imgv_item_post_graduate_school);
                break;
        }
        viewHolder.home_txtv_item_post_graduate_school_name.setText(bean.name);
        viewHolder.home_txtv_item_post_graduate_school_info.setText(bean.info);
        viewHolder.home_txtv_item_post_graduate_school_tag.setText(bean.tag);
    }

    @Override
    public int getItemCount() {
        return mSchoolBeanList.size();
    }

    class SchoolViewHolder extends RecyclerView.ViewHolder {
        private ImageView home_imgv_item_post_graduate_school;
        private TextView home_txtv_item_post_graduate_school_name;
        private TextView home_txtv_item_post_graduate_school_tag;
        private TextView home_txtv_item_post_graduate_school_info;

        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);
            home_imgv_item_post_graduate_school = itemView.findViewById(R.id.home_imgv_item_post_graduate_school);
            home_txtv_item_post_graduate_school_name = itemView.findViewById(R.id.home_imgv_item_post_graduate_school_name);
            home_txtv_item_post_graduate_school_tag = itemView.findViewById(R.id.home_imgv_item_post_graduate_school_tag);
            home_txtv_item_post_graduate_school_info = itemView.findViewById(R.id.home_imgv_item_post_graduate_school_info);
        }
    }
}
