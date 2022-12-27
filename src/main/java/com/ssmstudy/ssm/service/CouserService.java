package com.ssmstudy.ssm.service;

import com.ssmstudy.ssm.pojo.DataResult;

public interface CouserService {
    /**
     * 根据zhou和班级获取课表
     * @param zhou
     * @param banji
     * @return
     */
    DataResult getCourseInfoByZhou(Integer zhou,Integer banji);

    /**
     * 学生专用
     * 根据zhou和id获取课表
     * @param zhou
     * @param id
     * @return
     */
    DataResult getStudentCourseInfoByZhou(Integer zhou, Integer id);


    /**
     * 获取本周课表以及第几周了
     * @return
     */
    DataResult getThisWeekCourseInfo(Integer klassId);

    /**
     * admin，teacher
     * 获取最大周，通过班级id
     * @param klassid
     * @return
     */
    DataResult getMaxWeek(Integer klassid);

    /**
     * 学生专用
     * 获取最大周
     * @param sid
     * @return
     */
    DataResult getStudentMaxWeek(Integer sid);

    /**
     * 获取所有的学院班级
     * @return
     */
    DataResult getCascaderList();


    /**
     * 根据tid获取学院班级
     * @param tid
     * @return
     */
    DataResult getClassListByTid(Integer tid);


    /**
     * 学生专用
     * 通过sid获取当周课表
     * @param sid 学生id
     * @return
     */
    DataResult getStudentThisWeekCourseInfo(Integer sid);

    DataResult getMDCourseAllInfo();
}
