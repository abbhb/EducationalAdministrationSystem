package com.ssmstudy.ssm.pojo.course;

import com.google.gson.JsonArray;

public class CourseInfo {
    private Integer id;

    private Integer courseId;

    private Integer week;

    private Integer weekday;

    private Integer begin;
    private Integer length;

    private String classroom;

    public CourseInfo() {
    }

    public CourseInfo(Integer id, Integer courseId, Integer week, Integer weekday, Integer begin, Integer length, String classroom) {
        this.id = id;
        this.courseId = courseId;
        this.week = week;
        this.weekday = weekday;
        this.begin = begin;
        this.length = length;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", week=" + week +
                ", weekday=" + weekday +
                ", begin=" + begin +
                ", length=" + length +
                ", classroom='" + classroom + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
