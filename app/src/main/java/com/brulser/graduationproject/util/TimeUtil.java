package com.brulser.graduationproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc on 2017/4/17.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class TimeUtil {

    /**
     * 时间格式化
     */
    public static String GetTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return dateFormat.format(date);

    }

    /**
     * @param time 2017-04-26 20:37
     * @return date
     */
    public static Date Getdate(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();

    }


    /**
     * 计算相差的小时
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static int getTimeDifferenceHour(String starTime, String endTime) {
        int timehour = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);

            long diff = parse1.getTime() - parse.getTime();
            String string = Long.toString(diff);

            float parseFloat = Float.parseFloat(string);

            float hour1 = parseFloat / (60 * 60 * 1000);

            timehour = (int) hour1;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timehour;
    }

    /**
     * 计算相差的小时
     *
     * @param starTime
     * @param endTime
     * @return int timehour
     */
    public static int getTimeDifferenceHour(Date starTime, Date endTime) {
        int timehour = 0;
        try {

            long diff = endTime.getTime() - starTime.getTime();
            String string = Long.toString(diff);

            float parseFloat = Float.parseFloat(string);

            float hour1 = parseFloat / (60 * 60 * 1000);

            timehour = (int) hour1;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return timehour;
        }
        return timehour;
    }
}
