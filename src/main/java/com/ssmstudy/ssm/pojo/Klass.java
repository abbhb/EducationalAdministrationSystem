package com.ssmstudy.ssm.pojo;

public class Klass {
    private Integer klassId;

    private String klassName;

    public Klass() {
    }

    public Klass(Integer klassId, String klassName) {
        this.klassId = klassId;
        this.klassName = klassName;
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

    @Override
    public String toString() {
        return "Klass{" +
                "klassId=" + klassId +
                ", klassName='" + klassName + '\'' +
                '}';
    }
}
