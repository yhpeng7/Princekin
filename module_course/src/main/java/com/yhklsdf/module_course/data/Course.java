package com.yhklsdf.module_course.data;

public class Course {
    private int mCourseImgUrl;
    private String mCourseName;
    private String mType;
    private int mJoinCount;

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

    public int getJoinCount() {
        return mJoinCount;
    }

    public void setJoinCount(int joinCount) {
        mJoinCount = joinCount;
    }
}
