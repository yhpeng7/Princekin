package com.yhklsdf.module_community;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yhklsdf.lib_common.module.home.activity.PostGraduateActivity;
import com.yhklsdf.lib_common.module.home.activity.RecruitActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.DataViewHolder> {
    private Context mContext;
    private ArrayList<DataBean> mDataBeanList;

    public TechAdapter (Context mContext, ArrayList<DataBean> mDataBeanList) {
        this.mContext = mContext;
        this.mDataBeanList = mDataBeanList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.com_item_tech_recycler, viewGroup,false);
        DataViewHolder viewHolder = new DataViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull DataViewHolder viewHolder, int i) {
        DataBean databean = mDataBeanList.get(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext,SearchActivity.class);    //显示SearchView
//                mContext.startActivity(intent);
//                CheckInDialog checkInDialog = new CheckInDialog(mContext);  //显示签到Dialog
//                checkInDialog.show();
//                Intent intent = new Intent(mContext, PostGraduateActivity.class); //显示我要考研
//                mContext.startActivity(intent);
                Intent intent = new Intent(mContext, RecruitActivity.class);  //显示招聘
                mContext.startActivity(intent);
            }
        });
        switch (databean.avatar) {
            case "1":
                Glide.with(mContext).load(R.drawable.com_ic_avatar_1).into(viewHolder.com_cimgv_avatar);
                break;
            case "2":
                Glide.with(mContext).load(R.drawable.com_ic_avatar_2).into(viewHolder.com_cimgv_avatar);
                break;
            case "3":
                Glide.with(mContext).load(R.drawable.com_ic_avatar_3).into(viewHolder.com_cimgv_avatar);
                break;
            case "4":
                Glide.with(mContext).load(R.drawable.com_ic_avatar_4).into(viewHolder.com_cimgv_avatar);
                break;
            case "5":
                Glide.with(mContext).load(R.drawable.com_ic_avatar_5).into(viewHolder.com_cimgv_avatar);
                break;
        }
        viewHolder.com_txtv_name.setText(databean.name);
        viewHolder.com_txtv_college.setText(databean.college);
        viewHolder.com_txtv_title.setText(databean.title);
        viewHolder.com_txtv_recent.setText(databean.recent);
        viewHolder.com_txtv_time.setText(databean.time);
    }

    @Override
    public int getItemCount () {
        return mDataBeanList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView com_cimgv_avatar;
        private TextView com_txtv_name;
        private TextView com_txtv_college;
        private TextView com_txtv_title;
        private TextView com_txtv_recent;
        private TextView com_txtv_time;

        public DataViewHolder (@NonNull View itemView) {
            super(itemView);
            com_cimgv_avatar = itemView.findViewById(R.id.com_cimgv_tech_avatar);
            com_txtv_name = itemView.findViewById(R.id.com_txtv_tech_name);
            com_txtv_college = itemView.findViewById(R.id.com_txtv_tech_college);
            com_txtv_title = itemView.findViewById(R.id.com_txtv_tech_title);
            com_txtv_recent = itemView.findViewById(R.id.com_txtv_tech_recent);
            com_txtv_time = itemView.findViewById(R.id.com_txtv_tech_time);
        }
    }
}
