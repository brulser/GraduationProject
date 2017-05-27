package com.brulser.graduationproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.brulser.graduationproject.adapter.NewsFagAdapter;
import com.brulser.graduationproject.application.BaseApplication;
import com.brulser.graduationproject.fragment.NewsFragment;
import com.brulser.graduationproject.javabean.Newitem;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {


    //    @BindView(R.id.refresh_news)
//    XRefreshView refreshNews;
    @BindView(R.id.news_pager)
    ViewPager newsPager;
    @BindView(R.id.news_indicator)
    MagicIndicator newsIndicator;


    private NewsFagAdapter adapter;
    private List<NewsFragment> newsfragments;
    private List<String> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else {

        }
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
//        tv_content = (TextView) findViewById(R.id.tv_news_content);
//        tv_content.setText("<p class=\"art_t\">Ran/文 宸安/文</p><p class=\"art_t\">新浪娱乐讯 4月26日，据“关八”爆料，疑似张馨予的小号被网友扒出。从内容、手机型号以及配图等各方面分析，该账号的主人是张馨予的可能性非常之大，令人惊讶的是，该账号主人疑似遭到其他艺人打压，怨恨李晨为保护范冰冰而对自己冷酷无情。</p><p class=\"art_t\">从该账号的个人信息来看，该账号于2015年4月3日注册，距今有两年多的时间，截至目前为止，这个微博账号已经发布了191条内容，微博的简介里则写着这是一个“负面情绪的私人垃圾桶”，似乎该账号的主人将这个微博作为宣泄情绪的出口。</p><p class=\"art_t\">有网友从内容、手机型号以及微博配图等几个方面罗列六大证据，证明该微博账号的主人是张馨予。</p><p class=\"art_t\">证据一：点赞张馨予自拍</p><p class=\"art_t\">翻看两年中的所有微博，该账号的主人只点赞过两张图片，其中一张便是张馨予当年去戛纳电影节时发在微博上的自拍。</p><p class=\"art_t\">证据二：同样的时间段内更换同样的手机型号</p><p class=\"art_t\">该账号的主人在2016年12月中下旬更换手机型号，而张馨予的微博大号也在在同样的时间段里，更换了同样的手机型号。</p><p class=\"art_t\">证据三：喜欢的食物一致</p><p class=\"art_t\">该微博账号的主人曾透露自己最爱冬阴功粉，并晒出图片，张馨予本人曾在微博大号上晒图并放话“回北京必须吃冬阴功汤”，而且两个微博图中的碗垫一模一样。</p><p class=\"art_t\">证据四：</p><p class=\"art_t\">该微博账号于在16年6月14日分享了印有日文的水果，证明该账号主人极有可能在日本。同一天，张馨予通过微博晒出一张日文包装纸的冰淇淋图片，有网友还爆料称，12日当天在日本偶遇张馨予吃烤肉。</p><p class=\"art_t\">证据五：</p><p class=\"art_t\">去年平安夜，该微博账号曾晒出一张西瓜的照片，配文称吃西瓜时，喜欢先挖中间。张馨予在圣诞直播中，恰好现场吃西瓜，并且也是从中间开挖。</p><p class=\"art_t\">证据六：</p><p class=\"art_t\">最让人怀疑该账号的主人是张馨予的一点是，2016年6月8日，张馨予在微博中晒出三球冰淇淋的照片，而账号微博在16年的6月6日提前发布了一模一样的冰淇淋照片。</p><p class=\"art_t\">从以上种种迹象来看，该账号的主人很可能是张馨予。这个账号所发布的微博内容信息量较大，且负能量爆棚。</p><p class=\"art_t\">信息量一：张馨予疑似遭遇打压</p><p class=\"art_t\">在微博小号中，该账号主人曾多次抱怨自己遭遇出席发布会被删稿、看秀被除名，甚至被封杀的事件。4月1日当天，该账号主人还在小号中用拼音缩写隐晦地透露有人阻止自己参加《思美人》在《快乐大本营》的宣传录制。</p><p class=\"art_t\">信息量二：疑似对范冰冰李晨怨念深</p><p class=\"art_t\">该账号的主人曾痛恨地提到“公开信”对自己造成的伤害，放狠话称：“事到如今依然被你的公开信诟病，我到底做了什么伤害她的事？以我的性格，应该直接回馈你一封公开信！要撕就撕，别玩阴的！”似乎疑指前任李晨早前发布的长文爆料张馨予出轨。去年平安夜，该小号直接痛斥道：“我们分开以后互不亏欠，但分开后的两年时间，她如此对我，暗里对我做的事你也应该知道，可你亲自出马，要赶尽杀绝……”让人不免想到李晨和张馨予分手后，曾几次保护范冰冰，斥责张馨予的态度。</p><p class=\"art_t\">（Ran/文 宸安/文）</p>");

        initdata();
        initUI();
        initEvent();
    }

    private void initdata() {
        types = new ArrayList<>();
        newsfragments = new ArrayList<>();

        types.add("头条");
        types.add("新闻");
        types.add("财经");
        types.add("体育");
        types.add("娱乐");
        types.add("军事");
        types.add("教育");
        types.add("科技");
        types.add("NBA");
        types.add("股票");
        types.add("星座");
        types.add("女性");
        types.add("健康");
        types.add("育儿");
        for (String type : types) {
            NewsFragment fragment = new NewsFragment();
            fragment.settype(type);
            newsfragments.add(fragment);
        }

        adapter = new NewsFagAdapter(getSupportFragmentManager(), newsfragments);
        newsPager.setAdapter(adapter);

    }

    private void initUI() {

        newsIndicator.setBackgroundColor(Color.parseColor("#455a64"));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return types == null ? 0 : types.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(types.get(index));
                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newsPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }
        });
        newsIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(newsIndicator, newsPager);

    }

    private void initEvent() {

    }

    public void test(View view) {
        List<Newitem> list = BaseApplication.getNewsdao().queryBuilder().build().list();
        Log.d("test", "test: " + list.size() + "====" + BaseApplication.getDb().getPath());

    }
    //loadwebview

//    public void loadimg(View view) {
    //

//    }
}
