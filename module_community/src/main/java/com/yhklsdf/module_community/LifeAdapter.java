package com.yhklsdf.module_community;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zyp.cardview.YcCardView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LifeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements com_Constant {
    private Context mContext;
    private List<LifeBean> mLifeBeanList;
    private int type;

    public LifeAdapter (Context mContext, List<LifeBean> mLifeBeanList, int type) {
        this.mContext = mContext;
        this.mLifeBeanList = mLifeBeanList;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if (i == TEXT) {
            view = LayoutInflater.from(mContext).inflate(R.layout.com_item_life_recycler, viewGroup, false);
            LifeViewHolder lifeViewHolder = new LifeViewHolder(view);
            return lifeViewHolder;
        } else if (i == PHOTO) {
            view = LayoutInflater.from(mContext).inflate(R.layout.com_item_photo_life_recycler, viewGroup, false);
            LifePhotoViewHolder lifePhotoViewHolder = new LifePhotoViewHolder(view);
            return lifePhotoViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        LifeBean lifeBean = mLifeBeanList.get(i);
        if (viewHolder instanceof LifeViewHolder) {
            LifeViewHolder holder = (LifeViewHolder) viewHolder;
            holder.com_txtv_life_title.setText(lifeBean.title);
            holder.com_txtv_life_name.setText(lifeBean.name);
            holder.com_txtv_life_comment.setText(lifeBean.comment_count);
            holder.com_txtv_life_like.setText(lifeBean.like_count);
            holder.com_txtv_life_time.setText(lifeBean.time);
            switch (lifeBean.avatar) {
                case "1":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_1).into(holder.com_cimgv_life_avatar);
                    break;
                case "2":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_2).into(holder.com_cimgv_life_avatar);
                    break;
                case "3":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_3).into(holder.com_cimgv_life_avatar);
                    break;
                case "4":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_4).into(holder.com_cimgv_life_avatar);
                    break;
                case "5":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_5).into(holder.com_cimgv_life_avatar);
                    break;
            }
            switch (type) {
                case LIVING:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_living));
                    break;
                case RUN:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_run));
                    break;
                case RENT:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_rent));
                    break;
                case SECONDE:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_seconde));
                    break;
                case WORK:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_work));
                    break;
            }

        } else if (viewHolder instanceof LifePhotoViewHolder) {
            LifePhotoViewHolder holder = (LifePhotoViewHolder) viewHolder;
            holder.com_txtv_life_title.setText(lifeBean.title);
            holder.com_txtv_life_name.setText(lifeBean.name);
            holder.com_txtv_life_comment.setText(lifeBean.comment_count);
            holder.com_txtv_life_like.setText(lifeBean.like_count);
            holder.com_txtv_life_time.setText(lifeBean.time);
            switch (lifeBean.avatar) {
                case "1":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_1).into(holder.com_cimgv_life_avatar);
                    break;
                case "2":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_2).into(holder.com_cimgv_life_avatar);
                    break;
                case "3":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_3).into(holder.com_cimgv_life_avatar);
                    break;
                case "4":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_4).into(holder.com_cimgv_life_avatar);
                    break;
                case "5":
                    Glide.with(mContext).load(R.drawable.com_ic_avatar_5).into(holder.com_cimgv_life_avatar);
                    break;
            }
            Glide.with(mContext).load(ContextCompat.getDrawable(mContext, R.drawable.drawble_1)).apply(RequestOptions.centerCropTransform()).into(holder.com_imgv_life_p1);
            Glide.with(mContext).load(ContextCompat.getDrawable(mContext, R.drawable.drawble_2)).apply(RequestOptions.centerCropTransform()).into(holder.com_imgv_life_p2);
            Glide.with(mContext).load(ContextCompat.getDrawable(mContext, R.drawable.drawble_3)).apply(RequestOptions.centerCropTransform()).into(holder.com_imgv_life_p3);
            switch (type) {
                case LIVING:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_living));
                    break;
                case RUN:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_run));
                    break;
                case RENT:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_rent));
                    break;
                case SECONDE:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_seconde));
                    break;
                case WORK:
                    holder.com_cons_life.setBackground(ContextCompat.getDrawable(mContext, R.color.com_color_back_work));
                    break;
            }
        }
    }

    @Override
    public int getItemCount () {
        return mLifeBeanList.size();
    }

    @Override
    public int getItemViewType (int position) {
        return mLifeBeanList.get(position).type;
    }

    class LifeViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView com_cimgv_life_avatar;
        private TextView com_txtv_life_title;
        private TextView com_txtv_life_name;
        private TextView com_txtv_life_time;
        private TextView com_txtv_life_like;
        private TextView com_txtv_life_comment;
        private ConstraintLayout com_cons_life;

        public LifeViewHolder (@NonNull View itemView) {
            super(itemView);
            com_cimgv_life_avatar = itemView.findViewById(R.id.com_cimgv_life_avatar);
            com_txtv_life_title = itemView.findViewById(R.id.com_txtv_life_title);
            com_txtv_life_name = itemView.findViewById(R.id.com_txtv_life_name);
            com_txtv_life_time = itemView.findViewById(R.id.com_txtv_life_time);
            com_txtv_life_like = itemView.findViewById(R.id.com_txtv_life_like);
            com_txtv_life_comment = itemView.findViewById(R.id.com_txtv_life_comment);
            com_cons_life = itemView.findViewById(R.id.com_cons_life);
        }
    }

    class LifePhotoViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView com_cimgv_life_avatar;
        private TextView com_txtv_life_title;
        private TextView com_txtv_life_name;
        private TextView com_txtv_life_time;
        private TextView com_txtv_life_like;
        private TextView com_txtv_life_comment;
        private ImageView com_imgv_life_p1;
        private ImageView com_imgv_life_p2;
        private ImageView com_imgv_life_p3;
        private ConstraintLayout com_cons_life;

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
            com_cons_life = itemView.findViewById(R.id.com_cons_life);
        }
    }
}
