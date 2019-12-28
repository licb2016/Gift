package com.lcb.ljs.core.http.api;


import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author quchao
 * @date 2018/2/12
 */

public interface GeeksApis {

    String HOST = "https://www.wanandroid.com/";

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerData>>> getBannerData();


}
