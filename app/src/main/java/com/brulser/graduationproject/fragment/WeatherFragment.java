package com.brulser.graduationproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.brulser.graduationproject.R;
import com.brulser.graduationproject.javabean.Weather;
import com.brulser.graduationproject.util.DateUtil;
import com.brulser.graduationproject.util.StorageUtil;
import com.brulser.graduationproject.view.DashboardView2;
import com.brulser.graduationproject.view.GraphItem;
import com.brulser.graduationproject.view.WeatherGraph;
import com.brulser.graduationproject.view.WeatherScrollView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.weather_graph)
    WeatherGraph weatherGraph;
    @BindView(R.id.dash_pm25)
    DashboardView2 dashPm25;
    @BindView(R.id.tv_city_top)
    TextView tvCityTop;
    @BindView(R.id.tv_date_top)
    TextView tvDateTop;
    @BindView(R.id.tv_temper_top)
    TextView tvTemperTop;
    @BindView(R.id.tv_info_top)
    TextView tvInfoTop;
    @BindView(R.id.scorll_weather)
    NestedScrollView scorllWeather;
    @BindView(R.id.tv_airq_weahter)
    TextView tvAirqWeahter;
    @BindView(R.id.tv_pm25_weahter)
    TextView tvPm25Weahter;
    @BindView(R.id.tv_pm10_weahter)
    TextView tvPm10Weahter;
    @BindView(R.id.tv_kongtiao_title)
    TextView tvKongtiaoTitle;
    @BindView(R.id.tv_kongtiao_content)
    TextView tvKongtiaoContent;
    @BindView(R.id.tv_dress_title)
    TextView tvDressTitle;
    @BindView(R.id.tv_dress_content)
    TextView tvDressContent;
    @BindView(R.id.tv_sunshine_title)
    TextView tvSunshineTitle;
    @BindView(R.id.tv_sunshine_content)
    TextView tvSunshineContent;
    @BindView(R.id.tv_cleancar_title)
    TextView tvCleancarTitle;
    @BindView(R.id.tv_cleancar_content)
    TextView tvCleancarContent;
    @BindView(R.id.tv_cold_title)
    TextView tvColdTitle;
    @BindView(R.id.tv_cold_cotnent)
    TextView tvColdCotnent;
    @BindView(R.id.tv_sport_title)
    TextView tvSportTitle;
    @BindView(R.id.tv_sport_content)
    TextView tvSportContent;

    public WeatherFragment() {
        // Required empty public constructor
    }

    private String CityName;
    private Weather weather;
    private ArrayList<GraphItem> items;
    private boolean oncreate_flag = false;


    @Override
    public void onStop() {
        oncreate_flag = false;
        super.onStop();
    }

    @Override
    public void onStart() {
        Log.d("test", "onstartfrag");
        oncreate_flag = true;
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        // Inflate the layout for this fragment
        unbinder = ButterKnife.bind(this, view);
        oncreate_flag = true;

        String s = StorageUtil.ReadWeather(CityName);
        if (s.equals("")) {
            Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
//            tvTitle.setText("暂无数据");
        } else {
            weather = JSON.parseObject(s, Weather.class);
//            tvTitle.setText(s);


            initUI();
            initEvent();

        }


        return view;
    }

    private void initEvent() {
    }

    //        weather.getResult().getWeather().get(0).getInfo().getDay().get(3);//白天溫度

    private void initUI() {
        tvCityTop.setText(weather.getResult().getRealtime().getCity_name());
        tvDateTop.setText(weather.getResult().getRealtime().getDate() + " " + DateUtil.GetWeekFromString(weather.getResult().getRealtime().getWeek()));
        tvTemperTop.setText(weather.getResult().getRealtime().getWeather().getTemperature());
        tvInfoTop.setText(weather.getResult().getRealtime().getWeather().getInfo());
        /**
         * 曲线图
         */
        items = new ArrayList<>();
        for (int i = 0; i < weather.getResult().getWeather().size(); i++) {
            items.add(new GraphItem(DateUtil.GetMonthDay(weather.getResult().getWeather().get(i).getDate()) + " " + weather.getResult().getWeather().get(i).getInfo().getDay().get(1), Float.valueOf(weather.getResult().getWeather().get(i).getInfo().getDay().get(2))));

        }
        weatherGraph.setItems(items);
        /**
         * 空气质量图
         */
        if (weather.getResult().getPm25() != null) {
            dashPm25.setCreditValueWithAnim(Integer.valueOf(weather.getResult().getPm25().getPm25().getCurPm()));
            tvAirqWeahter.setText(": " + weather.getResult().getPm25().getPm25().getCurPm());
            tvPm25Weahter.setText(": " + weather.getResult().getPm25().getPm25().getPm25());
            tvPm10Weahter.setText(": " + weather.getResult().getPm25().getPm25().getPm10());
        }


        /**
         * 詳細內容
         */
        tvKongtiaoTitle.setText(weather.getResult().getLife().getInfo().getKongtiao().get(0));
        tvColdTitle.setText(weather.getResult().getLife().getInfo().getGanmao().get(0));
        tvCleancarTitle.setText(weather.getResult().getLife().getInfo().getXiche().get(0));
        tvDressTitle.setText(weather.getResult().getLife().getInfo().getChuanyi().get(0));
        tvSportTitle.setText(weather.getResult().getLife().getInfo().getYundong().get(0));
        tvSunshineTitle.setText(weather.getResult().getLife().getInfo().getZiwaixian().get(0));

        tvKongtiaoContent.setText(weather.getResult().getLife().getInfo().getKongtiao().get(1));
        tvColdCotnent.setText(weather.getResult().getLife().getInfo().getGanmao().get(1));
        tvCleancarContent.setText(weather.getResult().getLife().getInfo().getXiche().get(1));
        tvDressContent.setText(weather.getResult().getLife().getInfo().getChuanyi().get(1));
        tvSportContent.setText(weather.getResult().getLife().getInfo().getYundong().get(1));
        tvSunshineContent.setText(weather.getResult().getLife().getInfo().getZiwaixian().get(1));

    }


    public void setdata(String Cityname) {
        CityName = Cityname;
    }

    public String getWeatherType() {

//        if (weather == null) {
//            if (oncreate_flag) {
//                Log.d("test","执行weattherStoage");
//                String s = StorageUtil.ReadWeather(CityName);
//                if (s.equals("")) {
//                    return "晴";
////            tvTitle.setText("暂无数据");
//                } else {
//                    weather = JSON.parseObject(s, Weather.class);
//                    Log.d("test","执行weatther");
////            tvTitle.setText(s);
//
//                }
//            }
//
//        }
        return weather.getResult().getRealtime().getWeather().getInfo();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.dash_pm25)
    public void onViewClicked() {
        Log.d("test", "onclick25");
        if (weather.getResult().getPm25() != null) {
            dashPm25.setCreditValueWithAnim(Integer.valueOf(weather.getResult().getPm25().getPm25().getCurPm()));
        }
    }


    public void refreshUI() {
        Log.d("test", "oncreateflag" + oncreate_flag);
        if (oncreate_flag) {
            String s = StorageUtil.ReadWeather(CityName);
            if (s.equals("")) {
                Toast.makeText(getActivity(), "暂无数据,请刷新", Toast.LENGTH_SHORT).show();
//            tvTitle.setText("暂无数据");
            } else {
                weather = JSON.parseObject(s, Weather.class);
//            tvTitle.setText(s);
                initUI();
                initEvent();
            }
        }


    }

}
