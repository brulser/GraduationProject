package com.brulser.graduationproject.util;

import android.os.Environment;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.brulser.graduationproject.javabean.Weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by pc on 2017/4/13.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class StorageUtil {
    public static String WEATHER_DIR = Environment.getExternalStorageDirectory() + "/" + "天气";

    /**
     * 写入天气文件中
     *
     * @param responseString
     */
    public static void WriteWeather(String responseString) {
        Weather weather = JSON.parseObject(responseString, Weather.class);
        File F = new File(WEATHER_DIR);
        if (!F.exists()) {
            F.mkdir();
        }

        File f = new File(WEATHER_DIR + "/" + weather.getResult().getRealtime().getCity_name() + ".txt");

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            PrintStream fos = new PrintStream(f);
            fos.print(responseString);
//            Log.d("test", "写入成功");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取天气情况
     */
    public static String ReadWeather(String CityName) {
        File file = new File(WEATHER_DIR + "/" + CityName + ".txt");
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
//            Log.d("test", new String(filecontent));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(filecontent);
    }


}
