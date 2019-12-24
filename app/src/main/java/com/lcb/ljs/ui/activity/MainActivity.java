package com.lcb.ljs.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

import com.lcb.ljs.R;
import com.lcb.ljs.base.BaseMvpActivity;
import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.presenter.MainPresenter;
import com.lcb.ljs.util.GlideImageLoader;
import com.lcb.ljs.util.ProgressDialog;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lcb
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.et_username_login)
    TextInputEditText etUsernameLogin;

    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @BindView(R.id.head_banner)
    Banner mBanner;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return etPasswordLogin.getText().toString().trim();
    }

    @Override
    public void onSuccess(BaseObjectBean bean) {
        Toast.makeText(this, bean.toString(), Toast.LENGTH_SHORT).show();
        Logger.d(bean.toString());
    }


    @Override
    public void onBannerSuccess(BannerData bean) {
        if (bean.getData() != null) {
            List<BannerData.DataBean> bannerDataList = bean.getData();
            List<String> bannerImageList = new ArrayList<>();
            List<String> mBannerTitleList = new ArrayList<>();
            for (BannerData.DataBean bannerData : bannerDataList) {
                mBannerTitleList.add(bannerData.getTitle());
                bannerImageList.add(bannerData.getImagePath());
            }
            //设置banner样式
            mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
            //设置图片加载器
            mBanner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            mBanner.setImages(bannerImageList);
            //设置banner动画效果
            mBanner.setBannerAnimation(Transformer.DepthPage);
            //设置标题集合（当banner样式有显示title时）
            mBanner.setBannerTitles(mBannerTitleList);
            //设置自动轮播，默认为true
            mBanner.isAutoPlay(true);
            //设置轮播时间
            mBanner.setDelayTime(bannerDataList.size() * 400);
            //设置指示器位置（当banner模式中有指示器时）
            mBanner.setIndicatorGravity(BannerConfig.CENTER);

            //banner设置方法全部调用完毕时最后调用
            mBanner.start();

        }
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_signin_login)
    public void onViewClicked() {
        if (getUsername().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        mPresenter.getBanner();
    }
}
