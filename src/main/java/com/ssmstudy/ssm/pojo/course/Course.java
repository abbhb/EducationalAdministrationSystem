package com.ssmstudy.ssm.pojo.course;

import com.mysql.cj.xdevapi.JsonArray;

public class Course {
    private Integer id;

    private String courseName;


    private Integer courseTeacherId;

    private Integer klass;

    private Double credits;


    public Course() {
    }

    public Course(Integer id, String courseName, Integer courseTeacherId, Integer klass, Double credits) {
        this.id = id;
        this.courseName = courseName;
        this.courseTeacherId = courseTeacherId;
        this.klass = klass;
        this.credits = credits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(Integer courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseTeacherId=" + courseTeacherId +
                ", klass=" + klass +
                ", credits=" + credits +
                '}';
    }
}
