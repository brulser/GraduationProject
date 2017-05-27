package com.brulser.graduationproject.view;

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
public class GraphItem {
    private String xValue;
    private float yValue;

    public String getxValue() {
        return xValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public float getyValue() {
        return yValue;
    }

    public void setyValue(float yValue) {
        this.yValue = yValue;
    }

    public GraphItem(String xValue, float yValue) {

        this.xValue = xValue;
        this.yValue = yValue;
    }
}
