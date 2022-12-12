package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.NeedToken;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author qc200
 * Description:
 * 查询所有的teacher信息-->/teacher/getallteacher-->get
 * 查询相关课程teacher信息-->/teacher/getcourseteacher-->get
 */

@Controller
@ResponseBody
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @NeedToken
    @RequestMapping(value = "/teacher/getallteacher",method = RequestMethod.GET)
    @ResponseBody
    public DataResult getAllTeacher(){
        DataResult dataResult = teacherService.getAllTeacher();
        return dataResult;
    }
    @NeedToken
    @RequestMapping(value = "/teacher/getcourseteacher",method = RequestMethod.GET)
    @ResponseBody
    public DataResult getCourseTeacher(@RequestParam(name = "courseId", required = true) Integer courseId){
        DataResult dataResult = teacherService.getCourseTeacher(courseId);
        return dataResult;
    }
}
