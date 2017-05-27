package com.brulser.graduationproject;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.brulser.graduationproject.javabean.Weather;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    /**
     * ButterKinfe注入式框架替换 Findviewbyid
     */
    @BindView(R.id.tv_main_weather)
    TextView tvMainWeather;
    @BindView(R.id.tv_main_news)
    TextView tvMainNews;
    @BindView(R.id.tv_main_book)
    TextView tvMainBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    /**
     * ButterKinfe注入点击事件,功能入口
     * startActivity(Intent intent)界面跳转
     *
     * @param view
     */
    @OnClick({R.id.tv_main_weather, R.id.tv_main_news, R.id.tv_main_book})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_main_weather:
                ConnectivityManager systemService = (ConnectivityManager) getSystemService(MainActivity.this.CONNECTIVITY_SERVICE);
                if (systemService.getActiveNetworkInfo() == null) {
                    Snackbar.with(getApplicationContext()) // context
                            .text("请打开用户4G/Wifi网络连接")
                            .actionLabel("现在就去")
                            .actionColorResource(R.color.colorAccent)
                            .actionListener(new ActionClickListener() {
                                @Override
                                public void onActionClicked(Snackbar snackbar) {
                                    startActivity(new Intent(Settings.ACTION_SETTINGS));
                                }
                            }).show(MainActivity.this);
                    // text to display
                    // activity where it is displayed
                } else {
                    startActivity(new Intent(MainActivity.this, WeatherActivity.class));

                }
                break;
            case R.id.tv_main_news:
                startActivity(new Intent(MainActivity.this, NewsActivity.class));
                break;
            case R.id.tv_main_book:
                break;
        }
    }
}
