package com.brulser.graduationproject.adapter;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brulser.graduationproject.R;
import com.brulser.graduationproject.application.BaseApplication;
import com.brulser.graduationproject.javabean.Newitem;
import com.brulser.graduationproject.util.TimeUtil;
import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017/4/30.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class NewsListAdapter extends BaseAdapter {


    private List<Newitem> lists;
    private Context context;

    public NewsListAdapter(List<Newitem> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_list_item, null);
            holder = new ViewHolder();
            holder.img_news = (ImageView) convertView.findViewById(R.id.img_news);
            holder.tv_news_title = (TextView) convertView.findViewById(R.id.tv_news_title);
            holder.tv_news_typetime = (TextView) convertView.findViewById(R.id.tv_type);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tv_news_title.setText(lists.get(position).getTitle());
        holder.tv_news_typetime.setText(lists.get(position).getSrc() + "  " + TimeUtil.getTimeDifferenceHour(TimeUtil.Getdate(lists.get(position).getTime()), new Date()) + "小时前");

        Glide.with(context).load(lists.get(position).getPic())
                .placeholder(R.drawable.donghu_default)
                .into(holder.img_news);

//        Glide.getPhotoCacheDir(context).delete();
//        Glide.get(BaseApplication.getInstance()).clearDiskCache();


        return convertView;
    }

    public static class ViewHolder {
        ImageView img_news;
        TextView tv_news_title;
        TextView tv_news_typetime;
    }
}
