package com.ssmstudy.ssm.pojo;

public class Professional {
    private Integer id;

    private String professionalName;

    private Integer professionalCollegeId;

    public Professional() {
    }

    public Professional(Integer id, String professionalName, Integer professionalCollegeId) {
        this.id = id;
        this.professionalName = professionalName;
        this.professionalCollegeId = professionalCollegeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public Integer getProfessionalCollegeId() {
        return professionalCollegeId;
    }

    public void setProfessionalCollegeId(Integer professionalCollegeId) {
        this.professionalCollegeId = professionalCollegeId;
    }

    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                ", professionalName='" + professionalName + '\'' +
                ", professionalCollegeId=" + professionalCollegeId +
                '}';
    }
}
