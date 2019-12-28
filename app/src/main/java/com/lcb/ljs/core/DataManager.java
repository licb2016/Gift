package com.lcb.ljs.core;

import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseResponse;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.core.dao.HistoryData;
import com.lcb.ljs.core.db.DbHelper;
import com.lcb.ljs.core.http.HttpHelper;
import com.lcb.ljs.core.prefs.PreferenceHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author lcb
 * @date 2019-12-27 17:02
 */
public class DataManager implements DbHelper, HttpHelper, PreferenceHelper {

    private HttpHelper mHttpHelper;
    private PreferenceHelper mPreferenceHelper;
    private DbHelper mDbHelper;

    public DataManager(HttpHelper mHttpHelper, DbHelper mDbHelper, PreferenceHelper mPreferenceHelper ) {
        this.mHttpHelper = mHttpHelper;
        this.mDbHelper = mDbHelper;
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

    @Override
    public List<HistoryData> addHistoryData(String data) {
        return mDbHelper.addHistoryData(data);
    }

    @Override
    public void clearHistoryData() {
        mDbHelper.clearHistoryData();
    }

    @Override
    public List<HistoryData> loadAllHistoryData() {
        return mDbHelper.loadAllHistoryData();
    }

}
