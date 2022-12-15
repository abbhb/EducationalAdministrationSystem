package com.ssmstudy.ssm.service.impl;

import com.google.gson.*;
import com.ssmstudy.ssm.Const;
import com.ssmstudy.ssm.mapper.*;
import com.ssmstudy.ssm.pojo.DataResult;
import com.ssmstudy.ssm.pojo.Klass;
import com.ssmstudy.ssm.pojo.Professional;
import com.ssmstudy.ssm.pojo.User;
import com.ssmstudy.ssm.pojo.course.Course;
import com.ssmstudy.ssm.pojo.course.CourseInfo;
import com.ssmstudy.ssm.pojo.course.result.*;
import com.ssmstudy.ssm.service.CouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ssmstudy.ssm.utils.CourseUtil.getweek;

@Service
public class CourseServiceImpl implements CouserService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private KlassMapper klassMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProfessionalMapper professionalMapper;
    @Override
    public DataResult getCourseInfoByZhou(Integer zhou,Integer banji) {
        List<ResultCourseInfo> courseInfos = new ArrayList<>();
        List<CourseInfo> courseByZhou = courseInfoMapper.getCourseByZhou(zhou,banji);
        List<Course> courses = courseMapper.getAllCourseByKlass();//暂时模拟下班级查询课表
        List<ResultCourseInfo> resultCourseInfoList = new ArrayList<>();
        for (int i=1;i<=7;i++){
            List<CourseInfo> courseInfos1 = new ArrayList<>();
            List<ResultCourse> resultCourse = new ArrayList<>();
            for (CourseInfo course:
                 courseByZhou) {
                if (course.getWeekday()==i){
                    courseInfos1.add(course);
                }
            }
            for (int j=0;j<courseInfos1.size();j++){//一天的所有课，在分别取查数据库取得公共

                CourseInfo courseInfo = courseInfos1.get(j);
                for (int l=0;l< courses.size();l++){//在所有的课程中去找详细信息里面对应的课程
                    if (courses.get(l).getId()==courseInfo.getCourseId()){//说明这节课的信息找到了,courses.get(l).getCourseTeacherId()需要转换成teachername,courses.get(l).getKlass()需要转换成classname

                        Klass klassById = klassMapper.getKlassById(courseInfo.getKlass());
                        Professional professionalById = professionalMapper.getProfessionalById(klassById.getProfessionalId());
                        User teacherInfo = userMapper.getTeacherInfo(courses.get(l).getCourseTeacherId());
                        ResultCourse resultCourse1 = new ResultCourse(courseInfo.getBegin(),courses.get(l).getCourseName(),professionalById.getProfessionalName(),klassById.getKlassName(),courseInfo.getClassroom(),teacherInfo.getName(),courses.get(l).getCourseTeacherId(),courseInfo.getCourseId());
                        resultCourse.add(resultCourse1);
                        if (courseInfo.getLength()>=2){
                            for (int o=0;o<courseInfo.getLength()-1;o++){
                                ResultCourse resultCourse2 = new ResultCourse(courseInfo.getBegin()+o+1,courses.get(l).getCourseName(),professionalById.getProfessionalName(),klassById.getKlassName(),courseInfo.getClassroom(),teacherInfo.getName(),courses.get(l).getCourseTeacherId(),courseInfo.getCourseId());
                                resultCourse.add(resultCourse2);
                            }
                        }
                    }
                }
            }
            ResultCourseInfo resultCourseInfo = new ResultCourseInfo(i-1,resultCourse);//周1就是0，周二就是1
            resultCourseInfoList.add(resultCourseInfo);

        }

        ResultCourseInfo courseInfo = new ResultCourseInfo();



//        System.out.println(resultCourseInfoList);
        DataResult dataResult = new DataResult();
        dataResult.setStatus(200);
        dataResult.setMsg("查询成功");
        dataResult.setData(resultCourseInfoList);
        return dataResult;
    }

    @Override
    public DataResult getThisWeekCourseInfo() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        Date d=new Date();
        String startday="2022-12-5";//开学日期
        System.out.println("当天日期："+format.format(d));
        System.out.println("开课日期："+startday);
        //计算当前日期是开学的第几周
        Date d1 = null;
        try {
            d1 = format.parse(startday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int weeks = getweek(d,d1) ;//开学第几周
        String currSun = dateFm.format(d);//获取当前日期是星期几
        System.out.println("当天为开学第"+weeks+"周---"+currSun);


        List<ResultCourseInfo> courseInfos = new ArrayList<>();
        List<CourseInfo> courseByZhou = courseInfoMapper.getCourseByZhou(weeks,1);
        List<Course> courses = courseMapper.getAllCourseByKlass();//暂时模拟下班级查询课表
        List<ResultCourseInfo> resultCourseInfoList = new ArrayList<>();
        for (int i=1;i<=7;i++){
            List<CourseInfo> courseInfos1 = new ArrayList<>();
            List<ResultCourse> resultCourse = new ArrayList<>();

            for (CourseInfo course:
                    courseByZhou) {
                if (course.getWeekday()==i){
                    courseInfos1.add(course);
                }
            }
            for (int j=0;j<courseInfos1.size();j++){//一天的所有课，在分别取查数据库取得公共

                CourseInfo courseInfo = courseInfos1.get(j);
                for (int l=0;l< courses.size();l++){//在所有的课程中去找详细信息里面对应的课程
                    if (courses.get(l).getId()==courseInfo.getCourseId()){//说明这节课的信息找到了,courses.get(l).getCourseTeacherId()需要转换成teachername,courses.get(l).getKlass()需要转换成classname
                        Klass klassById = klassMapper.getKlassById(courseInfo.getKlass());
//                        System.out.println("getProfessionalId = " + klassById.getProfessionalId());
                        Professional professionalById = professionalMapper.getProfessionalById(klassById.getProfessionalId());
                        User teacherInfo = userMapper.getTeacherInfo(courses.get(l).getCourseTeacherId());
                        ResultCourse resultCourse1 = new ResultCourse(courseInfo.getBegin(),courses.get(l).getCourseName(),professionalById.getProfessionalName(),klassById.getKlassName(),courseInfo.getClassroom(),teacherInfo.getName(),courses.get(l).getCourseTeacherId(),courseInfo.getCourseId());
                        resultCourse.add(resultCourse1);
                        if (courseInfo.getLength()>=2){
                            for (int o=0;o<courseInfo.getLength()-1;o++){
                                ResultCourse resultCourse2 = new ResultCourse(courseInfo.getBegin()+o+1,courses.get(l).getCourseName(),professionalById.getProfessionalName(),klassById.getKlassName(),courseInfo.getClassroom(),teacherInfo.getName(),courses.get(l).getCourseTeacherId(),courseInfo.getCourseId());
                                resultCourse.add(resultCourse2);
                            }
                        }
                    }
                }
            }
            ResultCourseInfo resultCourseInfo = new ResultCourseInfo(i-1,resultCourse);//周1就是0，周二就是1
            resultCourseInfoList.add(resultCourseInfo);

        }

        ResultCourseInfo courseInfo = new ResultCourseInfo();

        ResultCourseInfoThisWeek resultCourseInfoThisWeek = new ResultCourseInfoThisWeek(resultCourseInfoList,weeks);

//        System.out.println(resultCourseInfoList);
        DataResult dataResult = new DataResult();
        dataResult.setStatus(200);
        dataResult.setMsg("查询成功");
        dataResult.setData(resultCourseInfoThisWeek);
        return dataResult;
    }

    @Override
    public DataResult getMaxWeek(Integer klassid) {
        List<CourseInfo> maxWeek = courseInfoMapper.getMaxWeek(klassid);
        int max = 0;

        for (CourseInfo c :
        maxWeek) {
            if (c.getWeek().intValue()>= max){
                max = c.getWeek().intValue();
            }
        }
        DataResult dataResult = new DataResult();
        dataResult.setData(max);
        dataResult.setMsg("获取成功");
        dataResult.setStatus(Const.ZHENGCHANG);
        return dataResult;
    }

    @Override
    public DataResult getCascaderList() {
        List<Professional> allProfessional = professionalMapper.getAllProfessional();
        List<ResultCascaderData> resultCascaderData = new ArrayList<>();


        for (Professional pro:
             allProfessional) {
            List<ResultCascaderItem> resultCascaderItems = new ArrayList<>();
            List<Klass> klassByProfessionalId = klassMapper.getKlassByProfessionalId(pro.getId());
            for (Klass klass:
                 klassByProfessionalId) {
                ResultCascaderItem resultCascaderItem = new ResultCascaderItem(klass.getKlassId(),klass.getKlassName());
                resultCascaderItems.add(resultCascaderItem);
            }
            ResultCascaderData resultCascaderData1 = new ResultCascaderData(pro.getId(),pro.getProfessionalName(),resultCascaderItems);
            resultCascaderData.add(resultCascaderData1);
        }
        DataResult dataResult = new DataResult();
        dataResult.setStatus(Const.ZHENGCHANG);
        dataResult.setData(resultCascaderData);
        return dataResult;
    }
}
