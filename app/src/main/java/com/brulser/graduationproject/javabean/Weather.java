package com.brulser.graduationproject.javabean;

import java.util.List;

/**
 * Created by pc on 2017/4/11.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class Weather {

    @Override
    public String toString() {
        return "Weather{" +
                "result=" + result +
                ", error_code=" + error_code +
                ", reason='" + reason + '\'' +
                '}';
    }

    /**
     * result : {"realtime":{"wind":{"windspeed":null,"direct":"西风","power":"1级","offset":null},"time":"22:00:00","weather":{"humidity":"93","img":"2","info":"阴","temperature":"13"},"dataUptime":"1491921422","date":"2017-04-11","city_code":"101200101","city_name":"武汉","week":"2","moon":"三月十五"},"life":{"date":"2017-4-11","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，较适宜进行各种运动，但因湿度偏高，请适当降低运动强度。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}},"weather":[{"date":"2017-04-11","week":"二","nongli":"三月十五","info":{"dawn":null,"day":["1","多云","17","","微风","06:00"],"night":["0","晴","8","","微风","18:48"]}},{"date":"2017-04-12","week":"三","nongli":"三月十六","info":{"dawn":["0","晴","8","无持续风向","微风","18:48"],"day":["1","多云","21","","微风","05:59"],"night":["0","晴","10","","微风","18:49"]}},{"date":"2017-04-13","week":"四","nongli":"三月十七","info":{"dawn":["0","晴","10","无持续风向","微风","18:49"],"day":["0","晴","24","","微风","05:58"],"night":["0","晴","12","","微风","18:50"]}},{"date":"2017-04-14","week":"五","nongli":"三月十八","info":{"dawn":["0","晴","12","无持续风向","微风","18:50"],"day":["0","晴","28","","微风","05:57"],"night":["0","晴","13","","微风","18:50"]}},{"date":"2017-04-15","week":"六","nongli":"三月十九","info":{"dawn":["0","晴","13","无持续风向","微风","18:50"],"day":["1","多云","29","","微风","05:56"],"night":["7","小雨","14","","微风","18:51"]}}],"pm25":{"key":"Wuhan","show_desc":"0","pm25":{"curPm":"68","pm25":"47","pm10":"66","level":"2","quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"},"dateTime":"2017年04月11日22时","cityName":"武汉"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":null,"direct":"西风","power":"1级","offset":null},"time":"22:00:00","weather":{"humidity":"93","img":"2","info":"阴","temperature":"13"},"dataUptime":"1491921422","date":"2017-04-11","city_code":"101200101","city_name":"武汉","week":"2","moon":"三月十五"}
         * life : {"date":"2017-4-11","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，较适宜进行各种运动，但因湿度偏高，请适当降低运动强度。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}}
         * weather : [{"date":"2017-04-11","week":"二","nongli":"三月十五","info":{"dawn":null,"day":["1","多云","17","","微风","06:00"],"night":["0","晴","8","","微风","18:48"]}},
         *          {"date":"2017-04-12","week":"三","nongli":"三月十六","info":{"dawn":["0","晴","8","无持续风向","微风","18:48"],"day":["1","多云","21","","微风","05:59"],"night":["0","晴","10","","微风","18:49"]}},
         *          {"date":"2017-04-13","week":"四","nongli":"三月十七","info":{"dawn":["0","晴","10","无持续风向","微风","18:49"],"day":["0","晴","24","","微风","05:58"],"night":["0","晴","12","","微风","18:50"]}},
         *          {"date":"2017-04-14","week":"五","nongli":"三月十八","info":{"dawn":["0","晴","12","无持续风向","微风","18:50"],"day":["0","晴","28","","微风","05:57"],"night":["0","晴","13","","微风","18:50"]}}
         *          ,{"date":"2017-04-15","week":"六","nongli":"三月十九","info":{"dawn":["0","晴","13","无持续风向","微风","18:50"],"day":["1","多云","29","","微风","05:56"],"night":["7","小雨","14","","微风","18:51"]}}]
         * pm25 : {"key":"Wuhan","show_desc":"0","pm25":{"curPm":"68","pm25":"47","pm10":"66","level":"2","quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"},"dateTime":"2017年04月11日22时","cityName":"武汉"}
         * isForeign : 0
         */

        private RealtimeBean realtime;
        private LifeBean life;
        private Pm25BeanX pm25;
        private int isForeign;
        private List<WeatherBeanX> weather;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25BeanX getPm25() {
            return pm25;
        }

        public void setPm25(Pm25BeanX pm25) {
            this.pm25 = pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public List<WeatherBeanX> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBeanX> weather) {
            this.weather = weather;
        }

        public static class RealtimeBean {
            /**
             * wind : {"windspeed":null,"direct":"西风","power":"1级","offset":null}
             * time : 22:00:00
             * weather : {"humidity":"93","img":"2","info":"阴","temperature":"13"}
             * dataUptime : 1491921422
             * date : 2017-04-11
             * city_code : 101200101
             * city_name : 武汉
             * week : 2
             * moon : 三月十五
             */

            private WindBean wind;
            private String time;
            private WeatherBean weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public static class WindBean {
                /**
                 * windspeed : null
                 * direct : 西风
                 * power : 1级
                 * offset : null
                 */

                private Object windspeed;
                private String direct;
                private String power;
                private Object offset;

                public Object getWindspeed() {
                    return windspeed;
                }

                public void setWindspeed(Object windspeed) {
                    this.windspeed = windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public Object getOffset() {
                    return offset;
                }

                public void setOffset(Object offset) {
                    this.offset = offset;
                }
            }

            public static class WeatherBean {
                /**
                 * humidity : 93
                 * img : 2
                 * info : 阴
                 * temperature : 13
                 */

                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class LifeBean {
            /**
             * date : 2017-4-11
             * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较适宜","天气较好，较适宜进行各种运动，但因湿度偏高，请适当降低运动强度。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]}
             */

            private String date;
            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * kongtiao : ["较少开启","您将感到很舒适，一般不需要开启空调。"]
                 * yundong : ["较适宜","天气较好，较适宜进行各种运动，但因湿度偏高，请适当降低运动强度。"]
                 * ziwaixi an : ["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]
                 * ganmao : ["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"]
                 * xiche : ["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"]
                 * wuran : null
                 * chuanyi : ["较冷","建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"]
                 */

                private Object wuran;
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> chuanyi;

                public Object getWuran() {
                    return wuran;
                }

                public void setWuran(Object wuran) {
                    this.wuran = wuran;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }
            }
        }

        public static class Pm25BeanX {
            /**
             * key : Wuhan
             * show_desc : 0
             * pm25 : {"curPm":"68","pm25":"47","pm10":"66","level":"2","quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"}
             * dateTime : 2017年04月11日22时
             * cityName : 武汉
             */

            private String key;
            private String show_desc;
            private Pm25Bean pm25;
            private String dateTime;
            private String cityName;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public static class Pm25Bean {
                /**
                 * curPm : 68
                 * pm25 : 47
                 * pm10 : 66
                 * level : 2
                 * quality : 良
                 * des : 可以正常在户外活动，易敏感人群应减少外出
                 */

                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }

        public static class WeatherBeanX {
            /**
             * date : 2017-04-11
             * week : 二
             * nongli : 三月十五
             * info : {"dawn":null,"day":["1","多云","17","","微风","06:00"],"night":["0","晴","8","","微风","18:48"]}
             */

            private String date;
            private String week;
            private String nongli;
            private InfoBeanX info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            public static class InfoBeanX {
                /**
                 * dawn : null
                 * day : ["1","多云","17","","微风","06:00"]
                 * night : ["0","晴","8","","微风","18:48"]
                 */

                private Object dawn;
                private List<String> day;
                private List<String> night;

                public Object getDawn() {
                    return dawn;
                }

                public void setDawn(Object dawn) {
                    this.dawn = dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}
