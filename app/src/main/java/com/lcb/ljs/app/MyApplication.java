package com.lcb.ljs.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lcb.ljs.BuildConfig;
import com.lcb.ljs.R;
import com.lcb.ljs.core.dao.DaoMaster;
import com.lcb.ljs.core.dao.DaoSession;
import com.lcb.ljs.di.component.AppComponent;
import com.lcb.ljs.di.component.DaggerAppComponent;
import com.lcb.ljs.di.module.AppModule;
import com.lcb.ljs.di.module.HttpModule;
import com.lcb.ljs.util.logger.TxtFormatStrategy;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author lcb
 * @date 2019-12-20 15:34
 */
public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    private RefWatcher refWatcher;

    private static MyApplication instance;

    private DaoSession mDaoSession;

    private static volatile AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        if (BuildConfig.DEBUG) {
            // 检测内存泄漏
            refWatcher = setupLeakCanary();
        }

        initGreenDao();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build();

        appComponent.inject(this);

        initLogger();
    }


    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build()));
        }
        //把log存到本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
    }


    public static synchronized MyApplication getInstance() {
        return instance;
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return getRefWatcher(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
