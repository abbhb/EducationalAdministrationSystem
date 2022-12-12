package com.ssmstudy.ssm.pojo.student;

public class Student {
    private Integer sid;

    private Integer klassId;

    private Double credits;


    public Student() {
    }

    public Student(Integer sid, Integer klassId, Double credits) {
        this.sid = sid;
        this.klassId = klassId;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", klassId=" + klassId +
                ", credits=" + credits +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getKlassId() {
        return klassId;
    }

    public void setKlassId(Integer klassId) {
        this.klassId = klassId;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }
}
