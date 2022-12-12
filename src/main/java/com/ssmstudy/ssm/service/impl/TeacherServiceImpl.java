package com.ssmstudy.ssm.service.impl;

import com.ssmstudy.ssm.Const;
import com.ssmstudy.ssm.mapper.TeacherMapper;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.teacher.Teacher;
import com.ssmstudy.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public DataResult getAllTeacher() {
        List<Teacher> allTeacher = teacherMapper.getAllTeacher();
        DataResult dataResult = new DataResult();
        if (allTeacher.size()!=0){
            dataResult.setStatus(Const.ZHENGCHANG);
            dataResult.setMsg("查询成功");
            dataResult.setData(allTeacher);
        }
        return dataResult;
    }

    @Override
    public DataResult getCourseTeacher(Integer courseId) {

        List<Teacher> teacherByCourseId = teacherMapper.getTeacherByCourseId(courseId.intValue()+"");
        DataResult dataResult = new DataResult();
        if (teacherByCourseId.size()!=0){
            dataResult.setStatus(Const.ZHENGCHANG);
            dataResult.setMsg("查询成功");
            dataResult.setData(teacherByCourseId);
        }
        return dataResult;
    }
}
