package com.ssmstudy.ssm.pojo.course.result;

public class ResultCourse {
    private Integer index;

    private String subject;

    private String major;

    private String klass;

    private String classroom;

    private  String teacherName;

    private Integer teacherId;

    private Integer courseId;

    private Integer length;

    public ResultCourse() {
    }

    public ResultCourse(Integer index, String subject, String major, String klass, String classroom, String teacherName, Integer teacherId, Integer courseId, Integer length) {
        this.index = index;
        this.subject = subject;
        this.major = major;
        this.klass = klass;
        this.classroom = classroom;
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.length = length;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ResultCourse{" +
                "index=" + index +
                ", subject='" + subject + '\'' +
                ", major='" + major + '\'' +
                ", klass='" + klass + '\'' +
                ", classroom='" + classroom + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                ", length=" + length +
                '}';
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacjerId() {
        return teacherId;
    }

    public void setTeacjerId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
