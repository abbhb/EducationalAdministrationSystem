package com.ssmstudy.ssm.service.impl;

import com.google.gson.*;
import com.ssmstudy.ssm.Const;
import com.ssmstudy.ssm.mapper.CourseMapper;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.course.Course;
import com.ssmstudy.ssm.pojo.course.CourseInfo;
import com.ssmstudy.ssm.service.CouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CouserService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public DataResult getAllCourseInfo() {
        Integer zhou = 1;//第一周
        List<Course> allCourse = courseMapper.getAllCourseByZhou(zhou);

        System.out.println(allCourse);
        List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
        DataResult dataResult = new DataResult();

        dataResult.setStatus(200);
        dataResult.setMsg("11");
        dataResult.setData(courseInfos);
        return dataResult;
    }

}
