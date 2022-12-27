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
    Course getCourseById(@Param("id") Integer id);

    /**
     * 获取所有课程
     * @return
     */
    List<Course> getAllCourseByKlass();

    /**
     * 获取某个老师所有的课程列表
     * @param tid
     * @return
     */
    List<Course> getCourseByTid(Integer tid);
}
