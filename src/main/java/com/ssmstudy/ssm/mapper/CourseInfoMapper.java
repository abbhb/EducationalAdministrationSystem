package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.course.CourseInfo;

import java.util.List;

public interface CourseInfoMapper {

    List<CourseInfo> getCourseByZhou(Integer zhou);
}
