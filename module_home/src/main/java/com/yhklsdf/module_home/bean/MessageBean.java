package com.yhklsdf.module_home.bean;

public class MessageBean {
    private String name;
    private String institute;
    private String type;
    private  String company;
    private  String salary;
    private String message;

    public MessageBean() {
    }

    public MessageBean(String name, String institute, String type, String company, String salary, String message) {
        this.name = name;
        this.institute = institute;
        this.type = type;
        this.company = company;
        this.salary = salary;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
