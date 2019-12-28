package com.lcb.ljs.app;

import android.app.Application;
import android.content.Context;

import com.lcb.ljs.BuildConfig;
import com.lcb.ljs.R;
import com.lcb.ljs.util.logger.TxtFormatStrategy;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author lcb
 * @date 2019-12-20 15:34
 */
public class MyApplication extends Application {

    private RefWatcher refWatcher;

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        if (BuildConfig.DEBUG) {
            // 检测内存泄漏
            refWatcher = setupLeakCanary();
        }

        initLogger();
    }


    private void initLogger() {
        //DEBUG版本才打控制台log
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                    tag(getString(R.string.app_name)).build()));
        }
        //把log存到本地
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy.newBuilder().
                tag(getString(R.string.app_name)).build(getPackageName(), getString(R.string.app_name))));
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


}
