package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.DataResult;

public interface TeacherService {
    DataResult getAllTeacher();

    DataResult getCourseTeacher(Integer courseId);
}
