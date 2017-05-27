package com.brulser.graduationproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.brulser.graduationproject.constant.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.webview_news)
    WebView webviewNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        String weburl = getIntent().getStringExtra(Constant.IT_WEBURL_NEWS);
        initWebview(weburl);

    }

    private void initWebview(String weburl) {

        webviewNews.getSettings().setJavaScriptEnabled(true);
        webviewNews.getSettings().setSupportZoom(true);
//        WebViewClient client = new WebViewClient();
//        client.onLoadResource(webview, "http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml");
//        webview.loadUrl("http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml");
        webviewNews.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
//        webview.loadUrl("http://ent.sina.com.cn/s/m/2017-04-26/doc-ifyetwsm0465100.shtml");
        webviewNews.loadUrl(weburl);
//
    }
}
