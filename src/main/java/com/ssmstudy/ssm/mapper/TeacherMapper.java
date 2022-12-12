package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.teacher.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    /**
     * 获取所有老师信息
     * @return
     */
    List<Teacher> getAllTeacher();

    /**
     * 此处后续需要过滤字符，防止注入
     * 获取相关课程的老师信息
     * @param courseId
     * @return
     */
    List<Teacher> getTeacherByCourseId(@Param("courseId") String courseId);
}
