package com.brulser.graduationproject.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.brulser.graduationproject.javabean.DaoMaster;
import com.brulser.graduationproject.javabean.DaoSession;
import com.brulser.graduationproject.javabean.NewitemDao;
import com.brulser.graduationproject.weathercity.db.DBManager;

/**
 * Created by pc on 2017/4/17.
 * Email:565881738@qq.com wellcome For Your Letters
 * Tel： 13638667479
 * Company：lafons
 * Alias： Brulser
 * Name：Shun Yao
 * 中文名：姚舜
 * Label：Focus, Seriousness, Efficiency, Results.
 */
public class BaseApplication extends Application {
    public static BaseApplication application;
    private DBManager dbHelper;
    private static SQLiteDatabase db;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //导入数据库
        dbHelper = new DBManager(this);
        dbHelper.openDatabase();
//        dbHelper.closeDatabase();
        initDataBase();


    }

    private void initDataBase() {
        DaoMaster.DevOpenHelper openHelper =
                new DaoMaster.DevOpenHelper
                        (this, "News_db", null);
        db = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static Application getInstance() {
        return application;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    public static NewitemDao getNewsdao() {
        return getDaoSession().getNewitemDao();
    }
}
