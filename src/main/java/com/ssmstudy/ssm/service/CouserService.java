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
     * 获取本周课表以及第几周了
     * @return
     */
    DataResult getThisWeekCourseInfo();

    DataResult getMaxWeek(Integer klassid);

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
}
