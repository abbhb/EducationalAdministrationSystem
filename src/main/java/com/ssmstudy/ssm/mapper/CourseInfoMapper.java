package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.course.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper {

    /**
     * 通过周次和班级id获取课程
     * @param zhou
     * @param classId
     * @return
     */
    List<CourseInfo> getCourseByZhou(@Param("zhou") Integer zhou, @Param("classId") Integer classId);

    /**
     * 通过班级id获得该班级最大周
     * @param klass
     * @return
     */
    List<CourseInfo> getMaxWeek(@Param("klass") Integer klass);

    /**
     * 通过课程course_id获取课程信息
     * @param id
     * @return
     */
    List<CourseInfo> getCourseInfoByCourseId(@Param("id")Integer id);
}
