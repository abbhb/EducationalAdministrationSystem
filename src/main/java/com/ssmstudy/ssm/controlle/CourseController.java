package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.NeedToken;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.service.CouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Date 13点53分
 * @author qc200
 * Description:
 * 查询所有的课程信息-->/course/allcourseinfo-->get
 */
@Controller
@ResponseBody
public class CourseController {
    @Autowired
    private CouserService couserService;
    @NeedToken
    @RequestMapping(value = "/course/allcourseinfo",method = RequestMethod.GET)
    public DataResult getAllCourseInfo(){
        return couserService.getAllCourseInfo();
    }

}
