package com.brulser.graduationproject.dynamicweather;

import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc on 2017/4/14.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class WeatherBgHelp {

    public static BaseDrawer.Type GetWeatherBgtype( String WeatherType){
//        public enum Type {
//            DEFAULT,
//            CLEAR_D, CLEAR_N,//晴天
//            RAIN_D, RAIN_N, //雨
//            SNOW_D, SNOW_N, //雪
//            CLOUDY_D, CLOUDY_N, //多云
//            OVERCAST_D, OVERCAST_N, //阴
//            FOG_D, FOG_N,			//雾
//            HAZE_D, HAZE_N, 		//雾霾
//            SAND_D,SAND_N,			//沙尘暴
//            WIND_D,WIND_N,			//大风
//            RAIN_SNOW_D, RAIN_SNOW_N,//雨夹雪
//            UNKNOWN_D, UNKNOWN_N	//未知
//        }


        switch (getCurrentTime()){
            case "day":
                    if (WeatherType.contains("雨")&&WeatherType.contains("雪")){
                        return BaseDrawer.Type.RAIN_SNOW_D;
                    }else if (WeatherType.contains("晴")){
                        return BaseDrawer.Type.CLEAR_D;
                    }else if (WeatherType.contains("雨")){
                        return BaseDrawer.Type.RAIN_D;
                    } else if (WeatherType.contains("雪")){
                        return BaseDrawer.Type.SNOW_D;
                    } else if (WeatherType.contains("云")){
                        return BaseDrawer.Type.CLOUDY_D;
                    } else if (WeatherType.contains("阴")){
                        return BaseDrawer.Type.OVERCAST_D;
                    }else if (WeatherType.contains("霾")){
                        return BaseDrawer.Type.HAZE_D;
                    }else if (WeatherType.contains("雾")){
                        return BaseDrawer.Type.FOG_D;
                    }else if (WeatherType.contains("沙")){
                        return BaseDrawer.Type.WIND_D;
                    }else if (WeatherType.contains("风")){
                        return BaseDrawer.Type.CLEAR_D;
                    }
                break;
            case "night":
                if (WeatherType.contains("雨")&&WeatherType.contains("雪")){
                    return BaseDrawer.Type.RAIN_SNOW_N;
                }else if (WeatherType.contains("晴")){
                    return BaseDrawer.Type.CLEAR_N;
                }else if (WeatherType.contains("雨")){
                    return BaseDrawer.Type.RAIN_N;
                } else if (WeatherType.contains("雪")){
                    return BaseDrawer.Type.SNOW_N;
                } else if (WeatherType.contains("云")){
                    return BaseDrawer.Type.CLOUDY_N;
                } else if (WeatherType.contains("阴")){
                    return BaseDrawer.Type.OVERCAST_N;
                }else if (WeatherType.contains("霾")){
                    return BaseDrawer.Type.HAZE_N;
                }else if (WeatherType.contains("雾")){
                    return BaseDrawer.Type.FOG_N;
                }else if (WeatherType.contains("沙")){
                    return BaseDrawer.Type.WIND_N;
                }else if (WeatherType.contains("风")){
                    return BaseDrawer.Type.CLEAR_N;
                }
                break;

        }
        return BaseDrawer.Type.DEFAULT;

    }

    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String hour= sdf.format(new Date());
        int k  = Integer.parseInt(hour)  ;
        if ((k>=0 && k<6) ||(k >=18 && k<24)){
            return "night";
        } else {
            return "day";
        }
    }

}

