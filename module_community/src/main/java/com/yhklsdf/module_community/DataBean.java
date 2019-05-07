package com.yhklsdf.module_community;

public class DataBean {
    String avatar;
    String name;
    String college;
    String title;
    String recent;
    String time;

    public DataBean (String avatar,String name, String college, String title, String recent, String time) {
        this.avatar = avatar;
        this.name = name;
        this.college = college;
        this.title = title;
        this.recent = recent;
        this.time = time;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCollege () {
        return college;
    }

    public void setCollege (String college) {
        this.college = college;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getRecent () {
        return recent;
    }

    public void setRecent (String recent) {
        this.recent = recent;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }
}
