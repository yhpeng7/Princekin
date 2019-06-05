package com.yhklsdf.module_course.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yhklsdf.module_course.R;
import com.yhklsdf.module_course.data.MyCourse;

import java.util.List;

public class MyCourseAdapter extends RecyclerView.Adapter<MyCourseAdapter.ViewHolder>
        implements View.OnClickListener {

    private Context mContext;
    private List<MyCourse> mData;
    private LayoutInflater mInflater;
    private OnClickListener mClickListener;

    public MyCourseAdapter(Context context, List<MyCourse> data, OnClickListener clickListener) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_recycler_my_course, viewGroup, false);
        view.setOnClickListener(this::onClick);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MyCourse course = mData.get(i);
        viewHolder.onBindData(mContext, course);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mClickListener != null) {
            mClickListener.onClick(v, (Integer) v.getTag());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mCourseImg;
        private TextView mTVCourseProgress;
        private TextView mTVCourseName;
        private TextView mTVCourseType;
        private ProgressBar mPBCourseProgress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseImg = itemView.findViewById(R.id.iv_course);
            mTVCourseName = itemView.findViewById(R.id.tv_course_name);
            mTVCourseType = itemView.findViewById(R.id.tv_course_type);
            mTVCourseProgress = itemView.findViewById(R.id.tv_course_progress);
            mPBCourseProgress = itemView.findViewById(R.id.pb_course_progress);
        }

        public void onBindData(Context context, MyCourse course) {
            Glide.with(context).load(course.getCourseUrl()).into(mCourseImg);
            mTVCourseProgress.setText(course.getCouseProgress()+"%");
            mPBCourseProgress.setProgress(course.getCouseProgress());
            mTVCourseName.setText(course.getCourseName());
            mTVCourseType.setText(course.getCourseType());
        }
    }

    public interface OnClickListener {
        void onClick(View view, int positon);
    }
}
