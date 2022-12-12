package com.ssmstudy.ssm.pojo.teacher;

public class Teacher {
    private Integer tid;

    private String courseId;

    public Teacher() {
    }

    public Teacher(Integer tid, String courseId) {
        this.tid = tid;
        this.courseId = courseId;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", courseId=" + courseId +
                '}';
    }
}
