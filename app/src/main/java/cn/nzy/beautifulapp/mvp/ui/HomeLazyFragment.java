package cn.nzy.beautifulapp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.livingBean.LivingBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.adater.LivingAdapter;
import cn.nzy.beautifulapp.base.BaseLazyFragment;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.contract.HomeContract;
import cn.nzy.beautifulapp.mvp.model.HomeMudle;
import cn.nzy.beautifulapp.mvp.presenter.HomePresenter;
import cn.nzy.beautifulapp.glide.GlideUtil;


/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeLazyFragment extends BaseLazyFragment<HomeContract.IHomeView, HomePresenter> implements HomeContract.IHomeView, BaseQuickAdapter.OnItemClickListener {
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
        args.putParcelable(ARG_INFO_ENTITY, categoryBean);
        fragment.setArguments(args);
        if (categoryBean != null) {
            fragment.setTitle(categoryBean.getName());
        }
        return fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected BaseModule setModule() {
        return new HomeMudle();
    }

    @Override
    public void initVariables(Bundle bundle) {
        info = (CategoryBean) bundle.getParcelable(ARG_INFO_ENTITY);

    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lazy_living, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        return rootView;
    }

    @Override
    protected void initData() {
        mDataBeanList = new ArrayList<>();
        mLivingadapter = new LivingAdapter(R.layout.item_living, mDataBeanList, this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(mLivingadapter);
        mLivingadapter.setOnItemClickListener(this);
        String category = info.getSlug();
        presenter.getNetData(category);
    }

    public void refreshData(CategoryBean categoryBean) {
        if (categoryBean != null) {
            info = categoryBean;

            Bundle args = getArguments();
            if (args != null) {
                args.putParcelable(ARG_INFO_ENTITY, info);
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
    public void showNetError(Throwable throwable) {
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
        View top = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        Banner banner = top.findViewById(R.id.head_banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.ScaleInOut);
        //设置标题集合（当banner样式有显示title时）
        ArrayList<String> titles = new ArrayList<>();
        for (LivingBean.BigsquareBean bigsquareBean : bigsquareBeans ) {
            titles.add(bigsquareBean.getTitle());
        }
        banner.setBannerTitles(titles);

        banner.setImages(bigsquareBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                LivingBean.BigsquareBean bean = (LivingBean.BigsquareBean) path;
                GlideUtil.setImage(HomeLazyFragment.this, bean.getThumb(), imageView);
            }
        }).start();
        mLivingadapter.addHeaderView(banner);
        mLivingadapter.setHeaderViewAsFlow(false);
    }

    @Override
    public void hideBanner() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        String uid = mDataBeanList.get(position).getUid();
        Intent intent = new Intent(getActivity(), PlayRoomActivity.class);
        intent.putExtra("uid", uid);
        startActivity(intent);
    }
}
