package com.yhklsdf.module_home.bean;

public class RankingBean {
    private String name;
    private String institute;
    private int points;
    private String type;
    private  String company;
    private  String salary;

    public RankingBean() {
    }

    public RankingBean(String name, String institute, int points, String type, String company, String salary) {
        this.name = name;
        this.institute = institute;
        this.points = points;
        this.type = type;
        this.company = company;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
