package com.lcb.ljs.contract;


import com.lcb.ljs.base.presenter.AbstractPresenter;
import com.lcb.ljs.base.view.AbstractView;


/**
 * @author lcb
 */
public interface MainContract {


    interface View extends AbstractView {

        /**
         * Show banner data
         *
         * @param bannerDataList List<BannerData>
         */
//        void showBannerData(List<BannerData> bannerDataList);
    }

    interface Presenter extends AbstractPresenter<View> {
        /**
         * Get banner data
         *
         * @param isShowError If show error
         */
        void getBannerData(boolean isShowError);
    }


}
