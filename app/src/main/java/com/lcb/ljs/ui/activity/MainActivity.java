package com.lcb.ljs.ui.activity;

import com.lcb.ljs.R;
import com.lcb.ljs.base.activity.BaseActivity;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.presenter.MainPresenter;

/**
 * @author lcb
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initEventAndData() {

    }





//    @BindView(R.id.head_banner)
//    Banner mBanner;
//    @Override
//    public void showBannerData(List<BannerData> bannerDataList) {
//        List<String> bannerImageList = new ArrayList<>();
//        List<String> mBannerTitleList = new ArrayList<>();
//        for (BannerData bannerData : bannerDataList) {
//            mBannerTitleList.add(bannerData.getTitle());
//            bannerImageList.add(bannerData.getImagePath());
//        }
//        //设置banner样式
//        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
//        //设置图片加载器
//        mBanner.setImageLoader(new GlideImageLoader());
//        //设置图片集合
//        mBanner.setImages(bannerImageList);
//        //设置banner动画效果
//        mBanner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
//        mBanner.setBannerTitles(mBannerTitleList);
//        //设置自动轮播，默认为true
//        mBanner.isAutoPlay(true);
//        //设置轮播时间
//        mBanner.setDelayTime(bannerDataList.size() * 400);
//        //设置指示器位置（当banner模式中有指示器时）
//        mBanner.setIndicatorGravity(BannerConfig.CENTER);
//
//        //banner设置方法全部调用完毕时最后调用
//        mBanner.start();
//    }


}
