package com.brulser.graduationproject.util;

/**
 * Created by pc on 2017/4/16.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class DateUtil {

    /**
     * 数字周转换为文字周
     */
    public static String GetWeekFromString(String week) {


        switch (week) {
            case "1":
                return "一";
            case "2":
                return "二";
            case "3":
                return "三";
            case "4":
                return "四";
            case "5":
                return "五";
            case "6":
                return "六";
            case "7":
                return "日";
        }

        return "";

    }

    /**
     * 截取日期的月份日子
     */
    public  static  String GetMonthDay(String monthday){

        return monthday.substring(monthday.indexOf("-")+1);


    }
}
