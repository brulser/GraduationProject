package com.brulser.graduationproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.andview.refreshview.XRefreshView;
import com.brulser.graduationproject.NewsDetailActivity;
import com.brulser.graduationproject.R;
import com.brulser.graduationproject.adapter.NewsListAdapter;
import com.brulser.graduationproject.application.BaseApplication;
import com.brulser.graduationproject.constant.Constant;
import com.brulser.graduationproject.javabean.Newitem;
import com.brulser.graduationproject.javabean.NewitemDao;
import com.brulser.graduationproject.javabean.News;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    @BindView(R.id.listview_news)
    ListView listviewNews;
    Unbinder unbinder;
    @BindView(R.id.refresh_news)
    XRefreshView refreshNews;


    public NewsFragment() {
        // Required empty public constructor
    }

    private NewsListAdapter adapter;
    private List<Newitem> list_news;
    private String type;

    public void settype(String type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);


        initdata();
        initUI();
        initEvent();


        return view;
    }

    /**
     * list_size 1:20 数据条数比
     */
    private int list_size = 1;

    private void initdata() {
        list_news = new ArrayList<>();
//        Log.d("test", BaseApplication.getNewsdao().queryBuilder().list().size() + "===");
        QueryBuilder<Newitem> newitemQueryBuilder = BaseApplication.getNewsdao().queryBuilder();
        list_news.addAll(newitemQueryBuilder.where(NewitemDao.Properties.Type.eq(type)).orderDesc(NewitemDao.Properties.Id).limit(list_size * 20).list());

        Log.d("test", list_news.size() + "====");

//        Log.d("test", list_news.toString());
//        Log.d("test", list_news.get(1).getTitle());
    }

    private void initUI() {
        adapter = new NewsListAdapter(list_news, getActivity());
        listviewNews.setAdapter(adapter);

        //设置静默加载
//        refreshNews.setSilenceLoadMore(true);
        //设置刷新完成以后，headerview固定的时间
        refreshNews.setPinnedTime(1000);
        refreshNews.setMoveForHorizontal(true);
        refreshNews.setPullLoadEnable(true);
        refreshNews.setAutoLoadMore(true);
        refreshNews.enableReleaseToLoadMore(true);
        refreshNews.enableRecyclerViewPullUp(true);
        refreshNews.enablePullUpWhenLoadCompleted(true);

//        refreshNews.setPullRefreshEnable(false);//禁止下拉刷新
//        refreshNews.setPullLoadEnable(false);//禁止上拉加载
    }

    private void initEvent() {

        refreshNews.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                AsyncHttpClient client_news = new AsyncHttpClient();
                client_news.get(getActivity(), "http://api.jisuapi.com/news/get?channel=" + type + "&start=0&num=40&appkey=b5967312169ee206", new TextHttpResponseHandler() {

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        refreshNews.stopRefresh(false);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {

                        News news = JSON.parseObject(responseString, News.class);
                        String type = news.getResult().getChannel();
                        NewitemDao newsdao = BaseApplication.getNewsdao();

                        for (News.ResultBean.ListBean bean : news.getResult().getList()) {
                            Newitem newitem = new Newitem();
                            newitem.setId(null);
                            newitem.setType(type);
                            newitem.setCategory(bean.getCategory());
                            newitem.setContent(bean.getContent());
                            newitem.setPic(bean.getPic());
                            newitem.setSrc(bean.getSrc());
                            newitem.setTime(bean.getTime());
                            newitem.setTitle(bean.getTitle());
                            newitem.setUrl(bean.getUrl());
                            newitem.setWeburl(bean.getWeburl());
                            //避免出现重复数据,设置title唯一性,如果有重复,出现异常,捕获退出,刷新数据
                            try {
                                newsdao.insert(newitem);
                            } catch (Exception e) {
                                refreshNews.stopRefresh(true);
                                refreshdata();
                                System.gc();
                                return;

                            }
                        }
                        Log.d("test", "插入数据成功");
                        refreshNews.stopRefresh(true);
                        //回收无用内存
                        System.gc();
                        refreshdata();
                    }
                });

            }

            @Override
            public void onLoadMore(boolean isSilence) {

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        // 刷新完成必须调用此方法停止加载
//                        refreshNews.stopLoadMore(false);
                        list_size++;
                        QueryBuilder<Newitem> newitemQueryBuilder = BaseApplication.getNewsdao().queryBuilder();
                        if (newitemQueryBuilder.where(NewitemDao.Properties.Type.eq(type)).list().size() + 20 <= list_size * 20) {
                            refreshNews.stopLoadMore(false);
                        } else {
                            list_news.clear();
                            list_news.addAll(newitemQueryBuilder.where(NewitemDao.Properties.Type.eq(type)).orderDesc(NewitemDao.Properties.Id).limit(list_size * 20).list());
                            adapter.notifyDataSetChanged();
                            refreshNews.stopLoadMore(true);
                        }


                    }
                }, 1000);
            }
        });

        listviewNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), "点击了" + position + "项目", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra(Constant.IT_WEBURL_NEWS, list_news.get(position).getUrl());
                startActivity(intent);

            }
        });
    }

    private void refreshdata() {
        list_news.clear();
        QueryBuilder<Newitem> newitemQueryBuilder = BaseApplication.getNewsdao().queryBuilder();
        list_news.addAll(newitemQueryBuilder.where(NewitemDao.Properties.Type.eq(type)).orderDesc(NewitemDao.Properties.Id).limit(list_size * 20).list());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
