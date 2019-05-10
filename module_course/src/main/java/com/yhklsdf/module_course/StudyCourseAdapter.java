package com.yhklsdf.module_course;

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
import com.yhklsdf.module_course.data.StudyCourse;

import java.util.List;

public class StudyCourseAdapter extends RecyclerView.Adapter<StudyCourseAdapter.ViewHolder>
        implements View.OnClickListener {

    private Context mContext;
    private List<StudyCourse> mData;
    private LayoutInflater mInflater;
    private OnClickListener mClickListener;

    public StudyCourseAdapter(Context context, List<StudyCourse> data, OnClickListener clickListener) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.study_course, viewGroup, false);
        view.setOnClickListener(this::onClick);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StudyCourse course = mData.get(i);
        viewHolder.onBindData(mContext, course);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (mClickListener != null) {
            mClickListener.onClick(v, (Integer) v.getTag());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mCourseImg;
        private TextView mTVCourseSchedule;
        private ProgressBar mPBCourseSchedule;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseImg = itemView.findViewById(R.id.iv_course);
            mTVCourseSchedule = itemView.findViewById(R.id.tv_study_schedule);
            mPBCourseSchedule = itemView.findViewById(R.id.pb_study_schedule);
        }

        public void onBindData(Context context, StudyCourse course) {
            Glide.with(context).load(R.mipmap.java_course).into(mCourseImg);
            mTVCourseSchedule.setText(course.getCouseProgress()+"%");
            mPBCourseSchedule.setProgress(course.getCouseProgress());
        }
    }

    public interface OnClickListener {
        void onClick(View view, int positon);
    }
}
