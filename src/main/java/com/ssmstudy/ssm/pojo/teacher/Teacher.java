package com.ssmstudy.ssm.pojo.teacher;

public class Teacher {
    private Integer tid;

    public Teacher() {
    }

    public Teacher(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }



    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                '}';
    }
}
