package com.ssmstudy.ssm.pojo.course.result;

import java.util.List;

public class ResultCourseInfoThisWeek {
    private List<ResultCourseInfo> resultCourseInfoList;

    private Integer thisweek;

    public ResultCourseInfoThisWeek() {
    }

    public ResultCourseInfoThisWeek(List<ResultCourseInfo> resultCourseInfoList, Integer thisweek) {
        this.resultCourseInfoList = resultCourseInfoList;
        this.thisweek = thisweek;
    }

    @Override
    public String toString() {
        return "ResultCourseInfoThisWeek{" +
                "resultCourseInfoList=" + resultCourseInfoList +
                ", thisweek=" + thisweek +
                '}';
    }

    public List<ResultCourseInfo> getResultCourseInfoList() {
        return resultCourseInfoList;
    }

    public void setResultCourseInfoList(List<ResultCourseInfo> resultCourseInfoList) {
        this.resultCourseInfoList = resultCourseInfoList;
    }

    public Integer getThisweek() {
        return thisweek;
    }

    public void setThisweek(Integer thisweek) {
        this.thisweek = thisweek;
    }
}
