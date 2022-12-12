package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.DataResult;

public interface CouserService {
    /**
     * 获取指定周的课程
     * @return
     */
    DataResult getCourseInfoByZhou(Integer id, Integer zhou);
}
