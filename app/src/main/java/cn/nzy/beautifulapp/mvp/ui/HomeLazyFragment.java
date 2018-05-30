package cn.nzy.beautifulapp.mvp.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.LivingBean.LivingBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.adater.LivingAdapter;
import cn.nzy.beautifulapp.base.BaseLazyFragment;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.contract.HomeContract;
import cn.nzy.beautifulapp.mvp.model.HomeMudle;
import cn.nzy.beautifulapp.mvp.presenter.HomePresenter;


/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeLazyFragment extends BaseLazyFragment<HomeContract.IHomeView, HomePresenter> implements HomeContract.IHomeView {
    private ProgressBar progressBar;
    private RecyclerView mRecyclerView;
    private CategoryBean info;
    private LivingAdapter mLivingadapter;
    private static final String ARG_INFO_ENTITY = "arg_info_entity";
    private List<LivingBean.DataBean> mDataBeanList;

    public HomeLazyFragment() {
    }

    public static HomeLazyFragment newInstance(CategoryBean categoryBean) {
        HomeLazyFragment fragment = new HomeLazyFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_INFO_ENTITY, categoryBean);
        fragment.setArguments(args);
        if (categoryBean != null) {
            fragment.setTitle(categoryBean.getName());
        }
        return fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected BaseModule setModule() {
        return new HomeMudle(this);
    }

    @Override
    public void initVariables(Bundle bundle) {
        info = (CategoryBean) bundle.getSerializable(ARG_INFO_ENTITY);

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_lazy_living, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        return rootView;
    }

    @Override
    protected void initData() {
        mDataBeanList = new ArrayList<>();
        mLivingadapter = new LivingAdapter(R.layout.item_living,mDataBeanList,this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(mLivingadapter);

        String category = info.getSlug();
        presenter.getNetData(category);
    }

    public void refreshData(CategoryBean categoryBean) {
        if (categoryBean != null) {
            info = categoryBean;

            Bundle args = getArguments();
            if (args != null) {
                args.putSerializable(ARG_INFO_ENTITY, info);
            }

            if (mRecyclerView != null) {
                mRecyclerView.setVisibility(View.GONE);
            }
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }

            if (isFragmentVisible()) {
                initData();
            } else {
                setForceLoad(true);
            }
        }
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {
    }

    @Override
    public void showNetError() {
        ToastUtils.showShort("网络错误，请检查网络");
    }


    @Override
    public void showData(List<LivingBean.DataBean> data) {
        mDataBeanList.addAll(data);
        mLivingadapter.notifyDataSetChanged();

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void goActivity() {

    }

    @Override
    public void reFresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void showBanner(List<LivingBean.BigsquareBean> bigsquareBeans) {

    }

    @Override
    public void hideBanner() {

    }
}
