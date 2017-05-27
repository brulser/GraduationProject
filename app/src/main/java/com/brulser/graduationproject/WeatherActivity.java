//<editor-fold desc="Description">
package com.brulser.graduationproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.alibaba.fastjson.JSON;
import com.brulser.graduationproject.constant.Constant;
import com.brulser.graduationproject.constant.WebApi;
import com.brulser.graduationproject.adapter.WeatherFagAdapter;
import com.brulser.graduationproject.dynamicweather.BaseDrawer;
import com.brulser.graduationproject.dynamicweather.DynamicWeatherView;
import com.brulser.graduationproject.dynamicweather.WeatherBgHelp;
import com.brulser.graduationproject.fragment.WeatherFragment;
import com.brulser.graduationproject.javabean.City;
import com.brulser.graduationproject.javabean.Weather;
import com.brulser.graduationproject.util.SharedPreUtil;
import com.brulser.graduationproject.util.StorageUtil;
import com.brulser.graduationproject.util.TimeUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.nispok.snackbar.Snackbar;
import com.yalantis.phoenix.PullToRefreshView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.bg_weather)
    DynamicWeatherView bgWeather;
    @BindView(R.id.weather_pager)
    ViewPager weatherPager;
    @BindView(R.id.weather_indiacator)
    MagicIndicator weatherIndiacator;
    @BindView(R.id.refresh_weather)
    PullToRefreshView refreshWeather;
    @BindView(R.id.btn_delectcity)
    ImageButton btnDelectcity;
    @BindView(R.id.btn_addcity)
    ImageButton btnAddcity;

    private List<WeatherFragment> fragments;
    private WeatherFagAdapter adapter;

    /**
     * 背景是否切换判断标志
     */
//    private boolean bg_change_flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else {

        }
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        initData();

        initUI();
        initEvent();

        initSnack();

    }

    private void initSnack() {
        int flag = getIntent().getIntExtra("start_flag", 0);
        Log.d("testflag", flag + "====");
        switch (flag) {
            case 0:
                break;
            case 1:
//                Snackbar bar = new SnackBar(WeatherActivity.this, "添加成功");
//                bar.setDismissTimer(2000);
//                bar.show();
                Snackbar.with(getApplicationContext()) // context
                        .text("添加成功") // text to display
                        .show(this); // activity where it is displayed
//                weatherPager.setCurrentItem(fragments.size()-1);
                break;
            case 2:
//                SnackBar bar1 = new SnackBar(WeatherActivity.this, "删除成功");
//                bar1.setDismissTimer(2000);
//                bar1.show();

                Snackbar.with(getApplicationContext()) // context
                        .text("删除成功") // text to display
                        .show(this); // activity where it is displayed

                break;
        }
    }


    private void initEvent() {
        weatherPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseDrawer.Type type = WeatherBgHelp.GetWeatherBgtype(fragments.get(position).getWeatherType());
                bgWeather.setDrawerType(type);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /**
         * 手动刷新事件.需判断事件差.避免重复更新数据
         */
        refreshWeather.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String olddate = SharedPreUtil.readString(Constant.SP_WEATHER_UPDATE_TIME, TimeUtil.GetTime(new Date()));


                ConnectivityManager systemService = (ConnectivityManager) getSystemService(WeatherActivity.this.CONNECTIVITY_SERVICE);
                if (systemService.getActiveNetworkInfo() == null) {
//                    SnackBar bar = new SnackBar(WeatherActivity.this, "无法连接到网络");
//                    bar.setDismissTimer(2000);
//                    bar.show();
                    Snackbar.with(getApplicationContext()) // context
                            .text("无法连接到网络") // text to display
                            .show(WeatherActivity.this); // activity where it is displayed

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshWeather.setRefreshing(false);
                        }
                    }, 2000);
                    return;
                }
//        计算更新事件.大于2个小时之后才能再次手动刷新
                if (Integer.valueOf(TimeUtil.getTimeDifferenceHour(olddate, TimeUtil.GetTime(new Date()))) < 2) {
                    Log.d("test", olddate + "=====");
//                    SnackBar bar = new SnackBar(WeatherActivity.this, "已经是最新数据");
//                    bar.setDismissTimer(2000);
//                    bar.show();
                    Snackbar.with(getApplicationContext()) // context
                            .text("已经是最新数据") // text to display
                            .show(WeatherActivity.this); // activity where it is displayed
                    /**
                     * handler操作UI
                     */
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshWeather.setRefreshing(false);

                        }
                    }, 2000);
                    return;
                }
                Log.d("test", "==" + TimeUtil.getTimeDifferenceHour(olddate, TimeUtil.GetTime(new Date())));

                RefreshData();

            }
        });
    }

    private void RefreshData() {


        RequestWeather();
        refreshWeather.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshWeather.setRefreshing(false);
                if (refresh_size == citys.size()) {
//                    SnackBar bar = new SnackBar(WeatherActivity.this, "更新成功");
//                    bar.setDismissTimer(2000);
//                    bar.show();

                    Snackbar.with(getApplicationContext()) // context
                            .text("更新成功") // text to display
                            .show(WeatherActivity.this); // activity where it is displayed

                    updateFragment();
                    SharedPreUtil.writeString(Constant.SP_WEATHER_UPDATE_TIME, TimeUtil.GetTime(new Date()));

                    //数据加载成功后再次初始化背景
                    Weather weather = JSON.parseObject(StorageUtil.ReadWeather(citys.get(weatherPager.getCurrentItem()).getCityname()), Weather.class);
                    if (null != weather && null != weather.getResult()) {
                        bgWeather.setDrawerType(WeatherBgHelp.GetWeatherBgtype(weather.getResult().getRealtime().getWeather().getInfo()));
                    } else {
                        bgWeather.setDrawerType(BaseDrawer.Type.UNKNOWN_D);
                    }


//            Toast.makeText(WeatherActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
                } else {
//                    SnackBar bar = new SnackBar(WeatherActivity.this, "部分数据更新失败");
//                    bar.setDismissTimer(2000);
//                    bar.show();

                    Snackbar.with(getApplicationContext()) // context
                            .text("部分数据更新失败") // text to display
                            .show(WeatherActivity.this); // activity where it is displayed
                }

            }
        }, 3000);
    }


    private List<City> citys = new ArrayList<>();

    private void initData() {
        /**
         * 首次进入，加载三个城市的数据：武汉，北京，上海
         */

        if (!SharedPreUtil.readBoolean(Constant.SP_FIRSTINIT) || JSON.parseArray(SharedPreUtil.readString(Constant.SP_CITY_ARRAY), City.class).size() == 0) {
            citys.add(new City("武汉"));
            citys.add(new City("北京"));
            citys.add(new City("上海"));
            SharedPreUtil.writeString(Constant.SP_CITY_ARRAY, JSON.toJSONString(citys));
            //设置未非首次进入
        }
        //清空城市
        citys.clear();

        //读取jsonstring 储存的城市
        citys.addAll(JSON.parseArray(SharedPreUtil.readString(Constant.SP_CITY_ARRAY), City.class));
        Log.d("testshare", citys.toString());

        fragments = new ArrayList<>();
        fragments.clear();
        for (City city : citys) {
            WeatherFragment weafag = new WeatherFragment();
            weafag.setdata(city.getCityname());
            fragments.add(weafag);
        }
        adapter = new WeatherFagAdapter(getSupportFragmentManager(), fragments);
        weatherPager.setAdapter(adapter);

        if (!SharedPreUtil.readBoolean(Constant.SP_FIRSTINIT)) {
            refreshWeather.setRefreshing(true);
            RefreshData();
            //设置未非首次进入
        }

    }


    private void initUI() {
        //初始化背景
        Weather weather = JSON.parseObject(StorageUtil.ReadWeather(
                citys.get(weatherPager.getCurrentItem()).getCityname()), Weather.class);

        if (null != weather && null != weather.getResult()) {
            bgWeather.setDrawerType(WeatherBgHelp.GetWeatherBgtype(
                    weather.getResult().getRealtime().getWeather().getInfo()));
        } else {
            bgWeather.setDrawerType(BaseDrawer.Type.UNKNOWN_D);
        }
        //初始化指示器
        CircleNavigator circleNavigator = new CircleNavigator(this);

        circleNavigator.setCircleCount(citys.size());
        circleNavigator.setCircleColor(Color.WHITE);
        circleNavigator.setCircleClickListener(new CircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                weatherPager.setCurrentItem(index);
            }
        });
        weatherIndiacator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(weatherIndiacator, weatherPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case INTENT_REQUEST_ADD_CODE:

                    final String cityname = data.getStringExtra("cityName");
                    City city = new City(cityname);
                    for (City c : citys) {
                        if (c.getCityname().equals(cityname)) {
                            Snackbar.with(getApplicationContext()) // context
                                    .text("已经存在" + cityname) // text to display
                                    .show(this); // activity where it is displayed

//                            Toast.makeText(WeatherActivity.this, "已经存在"+cityname, Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }


                    AsyncHttpClient client = new AsyncHttpClient();
                    String request_url = WebApi.WEATHER_API + cityname;
                    client.get(request_url, new TextHttpResponseHandler() {
                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                            SnackBar bar = new SnackBar(WeatherActivity.this, "添加 " + cityname + " 失败");
//                            bar.setDismissTimer(2000);
//                            bar.show();
                            Snackbar.with(getApplicationContext()) // context
                                    .text("添加 " + cityname + " 失败") // text to display
                                    .show(WeatherActivity.this); // activity where it is displayed

                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, String responseString) {
                            Log.d("test", responseString);
                            StorageUtil.WriteWeather(responseString);


                            citys.add(new City(cityname));
                            SharedPreUtil.writeString(Constant.SP_CITY_ARRAY, JSON.toJSONString(citys));

                            //消费一个activity.便于处理viewpager刷新和背景切换出现的bug
                            Intent i = new Intent(WeatherActivity.this, WeatherActivity.class);
                            i.putExtra("start_flag", 1);
                            startActivity(i);
                            WeatherActivity.this.finish();
                        }
                    });


                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
//        String olddate = SharedPreUtil.readString(Constant.SP_WEATHER_UPDATE_TIME, TimeUtil.GetTime(new Date()));
//
//        if (Integer.valueOf(TimeUtil.getTimeDifferenceHour(olddate, TimeUtil.GetTime(new Date()))) < 2 &&
//                SharedPreUtil.readBoolean(Constant.SP_FIRSTINIT)) {
//
//            SnackBar bar = new SnackBar(WeatherActivity.this, "已经是最新数据");
//            bar.setDismissTimer(2000);
//            bar.show();
//            /**
//             * handler操作UI
//             */
//
//        } else {
//            //进入天气界面必须刷新一次
//            refreshWeather.setRefreshing(true);
//            RefreshData();
//        }

        bgWeather.onResume();

        super.onResume();
    }

    @Override
    protected void onPause() {
        SharedPreUtil.writeBoolean(Constant.SP_FIRSTINIT, true);

        bgWeather.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        bgWeather.onDestroy();
        super.onDestroy();
    }

    private int refresh_size = 0;

    public void RequestWeather() {
//        Toast.makeText(WeatherActivity.this, "请求天气", Toast.LENGTH_SHORT).show();

        AsyncHttpClient client = new AsyncHttpClient();
        refresh_size = 0;

        for (City city : citys) {
            String request_url = WebApi.WEATHER_API + city.getCityname();
            client.get(request_url, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    Log.d("test", responseString);
                    StorageUtil.WriteWeather(responseString);
                    refresh_size++;


                }
            });
        }


    }


    private void updateFragment() {
        Log.d("test", fragments.size() + "==");
        for (WeatherFragment frag : fragments) {
            frag.refreshUI();
        }
    }

    public void ReadStorage() throws IOException {
        StorageUtil.ReadWeather("武汉");
    }

    public static final int INTENT_REQUEST_ADD_CODE = 1;

    @OnClick({R.id.btn_delectcity, R.id.btn_addcity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_delectcity:
//                Log.d("testviewpager",weatherPager.getCurrentItem()+"===");
//                citys.remove(weatherPager.getCurrentItem());
//                SharedPreUtil.writeString(Constant.SP_CITY_ARRAY, JSON.toJSONString(citys));
//                initData();
//                initUI();
//                updateFragment();
//                bg_change_flag = false;
                citys.remove(weatherPager.getCurrentItem());
                SharedPreUtil.writeString(Constant.SP_CITY_ARRAY, JSON.toJSONString(citys));

                Intent i = new Intent(WeatherActivity.this, WeatherActivity.class);
                i.putExtra("start_flag", 2);
                startActivity(i);
                WeatherActivity.this.finish();

                break;
            case R.id.btn_addcity:
                startActivityForResult(new Intent(WeatherActivity.this, WeatherCityActivity.class), INTENT_REQUEST_ADD_CODE);
                break;
        }
    }
}
//</editor-fold>
