package com.yhklsdf.module_course;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yhklsdf.module_course.data.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>
        implements View.OnClickListener {

    private Context mContext;
    private List<Course> mData;
    private LayoutInflater mInflater;
    private OnClickListener mClickListener;

    @Override
    public void onClick(View v) {
        if (mClickListener != null) {
            mClickListener.onClick(v, (Integer) v.getTag());
        }
    }

    public interface OnClickListener {
        void onClick(View view, int positon);
    }

    public CourseAdapter(Context context, List<Course> data, OnClickListener clickListener) {
        mContext = context;
        mData = data;
        mClickListener = clickListener;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.course, viewGroup, false);
        view.setOnClickListener(this::onClick);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(i);
        Course course = mData.get(i);
        viewHolder.onBindData(mContext, course);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mCourseImg;
        private TextView mCourseName;
        private TextView mCourseType;
        private TextView mJoinCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseImg = itemView.findViewById(R.id.iv_course);
            mCourseName = itemView.findViewById(R.id.tv_course_name);
            mCourseType = itemView.findViewById(R.id.tv_course_type);
            mJoinCount = itemView.findViewById(R.id.tv_join_count);
        }

        public void onBindData(Context context, Course course) {
            Glide.with(context).load(course.getCourseImgUrl()).into(mCourseImg);
            mCourseName.setText(course.getCourseName());
            mCourseType.setText(course.getType());
            mJoinCount.setText(String.valueOf(course.getJoinCount()));
        }
    }
}
