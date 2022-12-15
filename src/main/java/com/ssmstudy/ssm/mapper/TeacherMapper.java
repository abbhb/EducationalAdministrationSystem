package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.teacher.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    /**
     * 通过id获取teacher信息
     * @param id
     * @return
     */
    Teacher getTeacherById(@Param("id") Integer id);
}
