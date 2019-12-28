package com.lcb.ljs.core.prefs;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface PreferenceHelper {

    /**
     * Set login account
     *
     * @param account Account
     */
    void setLoginAccount(String account);

    /**
     * Set login password
     *
     * @param password Password
     */
    void setLoginPassword(String password);

    /**
     * Get login account
     *
     * @return account
     */
    String getLoginAccount();

    /**
     * Get login password
     *
     * @return password
     */
    String getLoginPassword();

    /**
     * Set login status
     *
     * @param isLogin IsLogin
     */
    void setLoginStatus(boolean isLogin);

    /**
     * Get login status
     *
     * @return login status
     */
    boolean getLoginStatus();

    /**
     * Set cookie
     *
     * @param domain Domain
     * @param cookie Cookie
     */
    void setCookie(String domain, String cookie);

    /**
     * Get cookie
     *
     * @param domain Domain
     * @return cookie
     */
    String getCookie(String domain);


    /**
     * Get night mode state
     *
     * @return if is night mode
     */
    boolean getNightModeState();

    /**
     * Set night mode state
     *
     * @param b current night mode state
     */
    void setNightModeState(boolean b);



}
