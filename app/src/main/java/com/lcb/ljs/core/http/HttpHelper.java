package com.lcb.ljs.core.http;

import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseResponse;
import com.lcb.ljs.bean.LoginBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author quchao
 * @date 2017/11/27
 */

public interface HttpHelper {


    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 取消收藏页面站内文章数据
     */
    Observable<BaseResponse<List<BannerData>>> getBannerData();


    /**
     * 退出登录
     * http://www.wanandroid.com/user/logout/json
     */
    @GET("user/logout/json")
    Observable<BaseResponse<LoginBean>> logout();

}
