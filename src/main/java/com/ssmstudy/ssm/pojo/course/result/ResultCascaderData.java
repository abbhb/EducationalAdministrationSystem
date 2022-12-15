package com.ssmstudy.ssm.pojo.course.result;

import java.util.List;

public class ResultCascaderData {

    private Integer value;

    private String label;

    private List<ResultCascaderItem> children;

    public ResultCascaderData(Integer value, String label, List<ResultCascaderItem> children) {
        this.value = value;
        this.label = label;
        this.children = children;
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

    public List<ResultCascaderItem> getChildren() {
        return children;
    }

    public void setChildren(List<ResultCascaderItem> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ResultCascaderData{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
