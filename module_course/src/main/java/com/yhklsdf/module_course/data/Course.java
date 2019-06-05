package com.yhklsdf.module_course.data;

public class Course {
    private int mCourseImgUrl;
    private String mCourseName;
    private String mType;

    public int getCourseImgUrl() {
        return mCourseImgUrl;
    }

    public void setCourseImgUrl(int courseImgUrl) {
        mCourseImgUrl = courseImgUrl;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
