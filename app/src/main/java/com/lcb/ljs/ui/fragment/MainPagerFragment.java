package com.lcb.ljs.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.lcb.ljs.R;
import com.lcb.ljs.base.fragment.BaseRootFragment;
import com.lcb.ljs.bean.FeedArticleData;
import com.lcb.ljs.contract.MainPagerContract;
import com.lcb.ljs.presenter.MainPagerPresenter;
import com.lcb.ljs.ui.adapter.ArticleListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * @author lcb
 * @date 2020-01-07 15:02
 */
public class MainPagerFragment extends BaseRootFragment<MainPagerPresenter> implements MainPagerContract.Presenter {

    @BindView(R.id.normal_view)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;

    private List<FeedArticleData> mFeedArticleDataList;
    private ArticleListAdapter mAdapter;

    private int articlePosition;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;
    private Banner mBanner;
    private boolean isRecreate;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
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

    @Override
    public void attachView(MainPagerContract.View view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {

    }

    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }
}
