package cn.nzy.beautifulapp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.base.BaseFragment;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.contract.ImgContract;
import cn.nzy.beautifulapp.mvp.model.ImgMudle;
import cn.nzy.beautifulapp.mvp.presenter.ImgPresenter;

/**
 * on 2018/5/21. created by nzy
 */

public class ImageFragment  extends BaseFragment<ImgContract.IImgView,ImgPresenter> implements ImgContract.IImgView, BaseQuickAdapter.OnItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup inflate = (ViewGroup) View.inflate(getActivity(), R.layout.fragment_living, null);
        return inflate;
    }

    @Override
    protected ImgPresenter setPresenter() {
        return new ImgPresenter();
    }

    @Override
    protected BaseModule setModule() {
        return new ImgMudle(this);
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showData(List<StaticImgBean.ResBean.VerticalBean> data) {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showRecyclerView() {

    }

    @Override
    public void refreshFinish() {

    }

    @Override
    public void refreshFail() {

    }

    @Override
    public void showNetError(Throwable throwable) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
