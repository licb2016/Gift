package com.lcb.ljs.presenter;

import com.lcb.ljs.base.presenter.BasePresenter;
import com.lcb.ljs.bean.FeedArticleData;
import com.lcb.ljs.contract.MainPagerContract;
import com.lcb.ljs.core.DataManager;

/**
 * @author lcb
 * @date 2020-01-07 15:03
 */
public class MainPagerPresenter extends BasePresenter<MainPagerContract.View> implements MainPagerContract.Presenter  {

    public MainPagerPresenter(DataManager dataManager) {
        super(dataManager);

    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public void loadMainPagerData() {

    }

    @Override
    public void getFeedArticleList(boolean isShowError) {

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public void addCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void cancelCollectArticle(int position, FeedArticleData feedArticleData) {

    }

    @Override
    public void getBannerData(boolean isShowError) {

    }

    @Override
    public void autoRefresh(boolean isShowError) {

    }

    @Override
    public void loadMore() {

    }
}
