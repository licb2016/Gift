package com.lcb.ljs.app;

import android.graphics.Color;

import java.io.File;

/**
 * @author lcb
 * @date 2019-12-27 16:30
 */
public class Constants {


    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";


    public static final String MY_SHARED_PREFERENCE = "my_shared_preference";


    public static final long DOUBLE_INTERVAL_TIME = 2000;


    /**
     * Tab colors
     */
    public static final int[] TAB_COLORS = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };


    /**
     * url
     */
    public static final String COOKIE = "Cookie";

    public static final String CURRENT_PAGE = "current_page";

    public static final String PROJECT_CURRENT_PAGE = "project_current_page";


    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";

    public static final String LOGIN_STATUS = "login_status";

    public static final String AUTO_CACHE_STATE = "auto_cache_state";

    public static final String NO_IMAGE_STATE = "no_image_state";

    public static final String NIGHT_MODE_STATE = "night_mode_state";

}
