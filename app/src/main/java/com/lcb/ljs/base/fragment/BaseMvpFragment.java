package com.lcb.ljs.base.fragment;


import com.lcb.ljs.base.presenter.BasePresenter;
import com.lcb.ljs.base.view.BaseView;

/**
 * @author lcb
 */
public abstract class BaseMvpFragment<T extends BasePresenter>  extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
