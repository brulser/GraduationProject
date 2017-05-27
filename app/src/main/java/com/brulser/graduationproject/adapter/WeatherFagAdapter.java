package com.brulser.graduationproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brulser.graduationproject.fragment.WeatherFragment;

import java.util.List;

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
public class WeatherFagAdapter extends FragmentPagerAdapter {
    private List<WeatherFragment> mFragments;


    public WeatherFagAdapter(FragmentManager fm, List<WeatherFragment> fragments) {
        super(fm);
        mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
