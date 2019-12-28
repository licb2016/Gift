package com.lcb.ljs.di.module;

import com.lcb.ljs.di.component.BaseActivityComponent;
import com.lcb.ljs.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author quchao
 * @date 2018/5/3
 */

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

//    @ContributesAndroidInjector(modules = SplashActivityModule.class)
//    abstract SplashActivity contributesSplashActivityInjector();
//
//    @ContributesAndroidInjector(modules = ArticleDetailActivityModule.class)
//    abstract ArticleDetailActivity contributesArticleDetailActivityInjector();
//
//    @ContributesAndroidInjector(modules = KnowledgeHierarchyDetailActivityModule.class)
//    abstract KnowledgeHierarchyDetailActivity contributesKnowledgeHierarchyDetailActivityInjector();
//
//    @ContributesAndroidInjector(modules = LoginActivityModule.class)
//    abstract LoginActivity contributesLoginActivityInjector();
//
//    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
//    abstract RegisterActivity contributesRegisterActivityInjector();
//
//    @ContributesAndroidInjector(modules = AboutUsActivityModule.class)
//    abstract AboutUsActivity contributesAboutUsActivityInjector();
//
//    @ContributesAndroidInjector(modules = SearchListActivityModule.class)
//    abstract SearchListActivity contributesSearchListActivityInjector();


}
