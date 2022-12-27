package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.College;

import java.util.List;

public interface CollegeMapper {
    /**
     * 获取所有College
     * @return
     */
    List<College> getAllCollege();
}
