package com.lcb.ljs.core.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.lcb.ljs.app.Constants;
import com.lcb.ljs.app.MyApplication;

import javax.inject.Inject;


/**
 * @author lcb
 */
public class PreferenceHelperImpl implements PreferenceHelper {

    private final SharedPreferences mPreferences;

    @Inject
    PreferenceHelperImpl() {
        mPreferences = MyApplication.getInstance().getSharedPreferences(Constants.MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferences.edit().putString(Constants.ACCOUNT, account).apply();
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferences.edit().putString(Constants.PASSWORD, password).apply();
    }

    @Override
    public String getLoginAccount() {
        return mPreferences.getString(Constants.ACCOUNT, "");
    }

    @Override
    public String getLoginPassword() {
        return mPreferences.getString(Constants.PASSWORD, "");
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferences.edit().putBoolean(Constants.LOGIN_STATUS, isLogin).apply();
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferences.getBoolean(Constants.LOGIN_STATUS, false);
    }

    @Override
    public void setCookie(String domain, String cookie) {
        mPreferences.edit().putString(domain, cookie).apply();
    }

    @Override
    public String getCookie(String domain) {
        return mPreferences.getString(Constants.COOKIE, "");
    }


    @Override
    public boolean getNightModeState() {
        return mPreferences.getBoolean(Constants.NIGHT_MODE_STATE, false);
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferences.edit().putBoolean(Constants.NIGHT_MODE_STATE, b).apply();
    }





}
