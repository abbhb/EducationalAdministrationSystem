package com.ssmstudy.ssm.pojo;

public class College {
    private Integer id;

    private String collegeName;

    public College() {
    }

    public College(Integer id, String collegeName) {
        this.id = id;
        this.collegeName = collegeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
