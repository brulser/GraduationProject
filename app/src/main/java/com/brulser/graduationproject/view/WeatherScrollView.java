package com.brulser.graduationproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by pc on 2017/4/14.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class WeatherScrollView extends ScrollView {
    private Context mcontext;

    public WeatherScrollView(Context context) {
        super(context);
        mcontext=context;
    }

    public WeatherScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mcontext=context;
    }

    public WeatherScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext=context;
    }




    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        DisplayMetrics metrics=mcontext.getResources().getDisplayMetrics();
        float density=metrics.density;

        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, (int)(density*maxOverScrollY), isTouchEvent);
    }
}
