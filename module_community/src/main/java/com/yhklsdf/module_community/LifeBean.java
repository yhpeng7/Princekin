package com.yhklsdf.module_community;

public class LifeBean {
    public String avatar;
    public String name;
    public String title;
    public String time;
    public String like_count;
    public String comment_count;
    public String photo;
    public int type;

    public LifeBean (String avatar, String name, String title, String time, String like_count, String comment_count, int type) {
        this.avatar = avatar;
        this.name = name;
        this.title = title;
        this.time = time;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.type = type;
    }
}