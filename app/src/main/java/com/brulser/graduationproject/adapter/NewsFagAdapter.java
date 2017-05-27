package com.brulser.graduationproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.brulser.graduationproject.fragment.NewsFragment;

import java.util.List;

/**
 * Created by pc on 2017/4/29.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class NewsFagAdapter extends FragmentPagerAdapter {

    private List<NewsFragment> list_newsfag;

    public NewsFagAdapter(FragmentManager fm, List<NewsFragment> list) {
        super(fm);

        list_newsfag = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list_newsfag.get(position);
    }

    @Override
    public int getCount() {
        return list_newsfag.size();
    }
}
