package com.ssmstudy.ssm.utils;

import java.util.Calendar;
import java.util.Date;

public class CourseUtil {

    public static int getweek(Date d1, Date d2) {
        // 获得当前日期与本周日相差的天数
        Calendar cd = Calendar.getInstance();
        cd.setTime(d2);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK)-1 ; // 因为按中国礼拜一作为第一天所以这里减1
        long daysBetween = (d1.getTime() - d2.getTime() + 1000000) / (60 * 60 * 24 * 1000);
        int weekindex= (int) (daysBetween / 7+1);
        if(dayOfWeek+daysBetween % 7>7){
            weekindex+=1;
        }
        return weekindex;
    }
}
