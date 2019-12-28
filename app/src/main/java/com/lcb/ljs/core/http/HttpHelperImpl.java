package com.lcb.ljs.core.http;

import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseResponse;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.core.http.api.GeeksApis;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * 对外隐藏进行网络请求的实现细节
 *
 * @author quchao
 * @date 2017/11/27
 */

public class HttpHelperImpl implements HttpHelper {

    private GeeksApis mGeeksApis;

    @Inject
    HttpHelperImpl(GeeksApis geeksApis) {
        mGeeksApis = geeksApis;
    }


    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mGeeksApis.getBannerData();
    }

    @Override
    public Observable<BaseResponse<LoginBean>> logout() {
        return null;
    }


}
