package com.yhklsdf.module_course.data;

public class MyCourse {
    private int mCourseUrl;
    private String mCourseName;
    private int mCouseProgress;
    private String mCourseType;

    public MyCourse() {
    }

    public String getCourseType() {
        return mCourseType;
    }

    public void setCourseType(String courseType) {
        mCourseType = courseType;
    }

    public int getCourseUrl() {
        return mCourseUrl;
    }

    public void setCourseUrl(int courseUrl) {
        mCourseUrl = courseUrl;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public int getCouseProgress() {
        return mCouseProgress;
    }

    public void setCouseProgress(int couseProgress) {
        mCouseProgress = couseProgress;
    }
}
