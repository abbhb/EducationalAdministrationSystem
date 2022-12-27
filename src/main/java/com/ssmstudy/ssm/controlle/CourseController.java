package com.ssmstudy.ssm.controlle;

import com.ssmstudy.ssm.Authorization.NeedToken;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.service.CouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Signature;
import java.util.Date;
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
    @RequestMapping(value = "/course/courseinfo",method = RequestMethod.POST)
    public DataResult getCourseInfo(@RequestBody Map<String, Object> course){
        Integer zhou = (Integer) course.get("z");
        Integer banji = (Integer) course.get("banji");
        return couserService.getCourseInfoByZhou(zhou,banji);
    }

    @NeedToken
    @RequestMapping(value = "/course/student/courseinfo",method = RequestMethod.POST)
    public DataResult getStudentCourseInfo(@RequestBody Map<String, Object> course){
        Integer zhou = (Integer) course.get("z");
        Integer id = null;
        try {
            id = (Integer) course.get("id");
        }catch (Exception e){
            String a = (String) course.get("id");
            if (a!=null){
                id = Integer.valueOf(a);
            }
        }
        return couserService.getStudentCourseInfoByZhou(zhou,id);
    }

    @NeedToken
    @RequestMapping(value = "/course/thisweekcourseinfo",method = RequestMethod.GET)
    public DataResult getThisWeekCourseInfo(@RequestParam(name = "klassId", required = true)Integer klassId){
        return couserService.getThisWeekCourseInfo(klassId);
    }

    @NeedToken
    @RequestMapping(value = "/course/student/thisweekcourseinfo",method = RequestMethod.GET)
    public DataResult getStudentThisWeekCourseInfo(@RequestParam(name = "sid", required = true)Integer sid){
        return couserService.getStudentThisWeekCourseInfo(sid);
    }

    @NeedToken
    @RequestMapping(value = "/course/courseinfo/maxweek",method = RequestMethod.POST)
    public DataResult getMaxWeek(@RequestBody Map<String, Object> course){
        Integer klassid = (Integer) course.get("classid");
        return couserService.getMaxWeek(klassid);
    }
    @NeedToken
    @RequestMapping(value = "/course/student/courseinfo/maxweek",method = RequestMethod.POST)
    public DataResult getStudentMaxWeek(@RequestBody Map<String, Object> course){
        Integer sid = null;
        try {
            sid = (Integer) course.get("sid");
        }catch (Exception e){
            e.printStackTrace();
            String s = (String) course.get("sid");
            if (s!=null){
                sid = Integer.valueOf(s);
            }
        }
        return couserService.getStudentMaxWeek(sid);
    }


    @NeedToken
    @RequestMapping(value = "/course/getcascaderlist",method = RequestMethod.GET)
    public DataResult getCascaderList(){
        return couserService.getCascaderList();
    }

    @NeedToken
    @RequestMapping(value = "/course/getclasslistbytid",method = RequestMethod.GET)
    public DataResult getClassListByTid(@RequestParam(name = "tid", required = true)Integer tid){
        return couserService.getClassListByTid(tid);//tid其实就是id
    }

    /**
     * 编辑课程界面列表
     * 无模糊查询，后序引入es
     * @return
     */
    @NeedToken
    @RequestMapping(value = "/course/courseinfo/mdcourse/allinfo",method = RequestMethod.GET)
    public DataResult getMDCourseAllInfo(){
        return couserService.getMDCourseAllInfo();
    }
}
