package com.lcb.ljs.presenter;

import com.lcb.ljs.R;
import com.lcb.ljs.app.MyApplication;
import com.lcb.ljs.base.presenter.BasePresenter;
import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.core.DataManager;
import com.lcb.ljs.ui.widget.BaseObserver;
import com.lcb.ljs.util.RxUtils;

import java.util.List;

import javax.inject.Inject;


/**
 * @author lcb
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getBannerData(boolean isShowError) {
        addSubscribe(mDataManager.getBannerData()
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<List<BannerData>>(mView,
                        MyApplication.getInstance().getString(R.string.failed_to_obtain_banner_data),
                        isShowError) {
                    @Override
                    public void onNext(List<BannerData> bannerDataList) {
//                        mView.showBannerData(bannerDataList);
                    }
                }));
    }



}
