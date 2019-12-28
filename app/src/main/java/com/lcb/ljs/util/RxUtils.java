package com.lcb.ljs.util;

import com.lcb.ljs.bean.BaseResponse;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.core.http.exception.OtherException;

import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chao.qu at 2017/10/20
 *
 * @author quchao
 */

public class RxUtils {

    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> rxFlSchedulerHelper() {
        return flowable -> flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一返回结果处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse -> {
                    if (baseResponse.getErrorCode() == BaseResponse.SUCCESS
                            && baseResponse.getData() != null
                            && CommonUtils.isNetworkConnected()) {
                        return createData(baseResponse.getData());
                    } else {
                        return Observable.error(new OtherException());
                    }
                });
    }

    /**
     * 退出登录返回结果处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleLogoutResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse -> {
                    if (baseResponse.getErrorCode() == BaseResponse.SUCCESS
                            && CommonUtils.isNetworkConnected()) {
                        //创建一个非空数据源，避免onNext()传入null
                        return createData(CommonUtils.cast(new LoginBean()));
                    } else {
                        return Observable.error(new OtherException());
                    }
                });
    }


    /**
     * 得到 Observable
     *
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }


}