package com.yhklsdf.module_community;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LifeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  implements com_Constant{
    Context mContext;
    List<LifeBean> mLifeBeanList;
    public LifeAdapter(Context mContext,List<LifeBean> mLifeBeanList){
        this.mContext = mContext;
        this.mLifeBeanList = mLifeBeanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    class LifeViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView com_cimgv_life_avatar;
        private TextView com_txtv_life_title;
        private TextView com_txtv_life_name;
        private TextView com_txtv_life_time;
        private TextView com_txtv_life_like;
        private TextView com_txtv_life_comment;
        public LifeViewHolder (@NonNull View itemView) {
            super(itemView);
            com_cimgv_life_avatar = itemView.findViewById(R.id.com_cimgv_life_avatar);
            com_txtv_life_title = itemView.findViewById(R.id.com_txtv_life_title);
            com_txtv_life_name = itemView.findViewById(R.id.com_txtv_life_name);
            com_txtv_life_time = itemView.findViewById(R.id.com_txtv_life_time);
            com_txtv_life_like = itemView.findViewById(R.id.com_txtv_life_like);
            com_txtv_life_comment = itemView.findViewById(R.id.com_txtv_life_comment);
        }
    }
    class LifePhotoViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView com_cimgv_life_avatar;
        private TextView com_txtv_life_title;
        private TextView com_txtv_life_name;
        private TextView com_txtv_life_time;
        private TextView com_txtv_life_like;
        private TextView com_txtv_life_comment;
        private ImageView com_imgv_life_p1;
        private ImageView com_imgv_life_p2;
        private ImageView com_imgv_life_p3;
        public LifePhotoViewHolder (@NonNull View itemView) {
            super(itemView);
            com_cimgv_life_avatar = itemView.findViewById(R.id.com_cimgv_life_avatar);
            com_txtv_life_title = itemView.findViewById(R.id.com_txtv_life_title);
            com_txtv_life_name = itemView.findViewById(R.id.com_txtv_life_name);
            com_txtv_life_time = itemView.findViewById(R.id.com_txtv_life_time);
            com_txtv_life_like = itemView.findViewById(R.id.com_txtv_life_like);
            com_txtv_life_comment = itemView.findViewById(R.id.com_txtv_life_comment);
            com_imgv_life_p1 = itemView.findViewById(R.id.com_imgv_life_p1);
            com_imgv_life_p2 = itemView.findViewById(R.id.com_imgv_life_p2);
            com_imgv_life_p3 = itemView.findViewById(R.id.com_imgv_life_p3);
        }
    }
}
