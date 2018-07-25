package cn.nzy.beautifulapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseContract.IBaseView, P extends BasePresenter> extends Fragment implements BaseContract.IBaseView {
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = setPresenter();
        presenter.attatchWindow(setModule());
        View view = initViews(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public P presenter;

    protected abstract P setPresenter();

    protected abstract BaseModule setModule();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {

            presenter.detachWindow();
        }
        if (unbinder != null) {

            unbinder.unbind();
        }
    }

    protected abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initData();



}