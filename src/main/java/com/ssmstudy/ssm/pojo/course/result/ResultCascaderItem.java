package com.ssmstudy.ssm.pojo.course.result;

public class ResultCascaderItem {
    private Integer value;

    private String label;


    public ResultCascaderItem() {
    }

    public ResultCascaderItem(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ResultCascaderItem{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
