package com.ssmstudy.ssm.pojo.course.result;

import java.util.List;

public class ResultCourseInfo {
    private Integer week;

    private List<ResultCourse> resultCourse;


    public ResultCourseInfo() {
    }

    public ResultCourseInfo(Integer week, List<ResultCourse> resultCourse) {
        this.week = week;
        this.resultCourse = resultCourse;
    }

    
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public List<ResultCourse> getResultCourse() {
        return resultCourse;
    }

    public void setResultCourse(List<ResultCourse> courses) {
        this.resultCourse = courses;
    }
}
