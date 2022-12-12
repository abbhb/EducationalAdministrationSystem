package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.course.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    /**
     * 通过周来获取当周的课表
     * @param id
     * @return
     */
    List<Course> getCourseById(@Param("id") Integer id);


}
