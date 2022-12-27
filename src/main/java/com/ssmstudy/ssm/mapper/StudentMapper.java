package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.student.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    /**
     * 通过学生id查找学生信息
     * @param id
     * @return
     */
    Student getKlassIdBySid(@Param("id") Integer id);
}
