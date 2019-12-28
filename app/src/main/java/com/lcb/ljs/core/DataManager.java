package com.lcb.ljs.core;

import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseResponse;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.core.http.HttpHelper;
import com.lcb.ljs.core.prefs.PreferenceHelper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.HTTP;

/**
 * @author lcb
 * @date 2019-12-27 17:02
 */
public class DataManager implements HttpHelper, PreferenceHelper {

    private HttpHelper mHttpHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper mHttpHelper, PreferenceHelper mPreferenceHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mPreferenceHelper = mPreferenceHelper;
    }

    @Override
    public boolean getNightModeState() {
        return mPreferenceHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferenceHelper.setNightModeState(b);
    }


    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferenceHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferenceHelper.getLoginPassword();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }

    @Override
    public void setCookie(String domain, String cookie) {
        mPreferenceHelper.setCookie(domain, cookie);
    }

    @Override
    public String getCookie(String domain) {
        return mPreferenceHelper.getCookie(domain);
    }

    @Override
    public Observable<BaseResponse<LoginBean>> logout() {
        return mHttpHelper.logout();
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHttpHelper.getBannerData();
    }
}
