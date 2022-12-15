package com.ssmstudy.ssm.pojo;

public class Klass {
    private Integer klassId;

    private String klassName;

    private Integer professionalId;

    public Klass() {
    }

    public Klass(Integer klassId, String klassName, Integer professionalId) {
        this.klassId = klassId;
        this.klassName = klassName;
        this.professionalId = professionalId;
    }

    @Override
    public String toString() {
        return "Klass{" +
                "klassId=" + klassId +
                ", klassName='" + klassName + '\'' +
                ", professionalId=" + professionalId +
                '}';
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getKlassId() {
        return klassId;
    }

    public void setKlassId(Integer klassId) {
        this.klassId = klassId;
    }

    public String getKlassName() {
        return klassName;
    }

    public void setKlassName(String klassName) {
        this.klassName = klassName;
    }

}
