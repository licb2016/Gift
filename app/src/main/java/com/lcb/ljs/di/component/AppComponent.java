package com.lcb.ljs.di.component;


import com.lcb.ljs.app.MyApplication;
import com.lcb.ljs.core.DataManager;
import com.lcb.ljs.di.module.AbstractAllActivityModule;
import com.lcb.ljs.di.module.AbstractAllDialogFragmentModule;
import com.lcb.ljs.di.module.AbstractAllFragmentModule;
import com.lcb.ljs.di.module.AppModule;
import com.lcb.ljs.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AbstractAllFragmentModule.class,
        AbstractAllDialogFragmentModule.class,
        AppModule.class,
        HttpModule.class})
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param wanAndroidApp WanAndroidApp
     */
    void inject(MyApplication wanAndroidApp);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    MyApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
