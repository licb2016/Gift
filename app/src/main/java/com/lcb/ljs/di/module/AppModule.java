package com.lcb.ljs.di.module;


import com.lcb.ljs.app.MyApplication;
import com.lcb.ljs.core.DataManager;
import com.lcb.ljs.core.db.DbHelper;
import com.lcb.ljs.core.db.DbHelperImpl;
import com.lcb.ljs.core.http.HttpHelper;
import com.lcb.ljs.core.http.HttpHelperImpl;
import com.lcb.ljs.core.prefs.PreferenceHelper;
import com.lcb.ljs.core.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(DbHelperImpl realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
