package cn.nzy.beautifulapp.mvp.ui.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.adater.ImgAdapter;
import cn.nzy.beautifulapp.base.BaseFragment;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.contract.ImgContract;
import cn.nzy.beautifulapp.mvp.model.ImgMudle;
import cn.nzy.beautifulapp.mvp.presenter.ImgPresenter;
import cn.nzy.beautifulapp.mvp.ui.ImagDetailActivity;
import cn.nzy.beautifulapp.view.SpaceItemDecoration;

/**
 * on 2018/5/21. created by nzy
 */

public class ImageFragment extends BaseFragment<ImgContract.IImgView, ImgPresenter> implements ImgContract.IImgView, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<StaticImgBean.ResBean.VerticalBean> mImageList;
    private ImgAdapter mImgAdapter;

    @Override
    protected ImgPresenter setPresenter() {
        return new ImgPresenter(this);
    }

    @Override
    protected BaseModule setModule() {
        return new ImgMudle();
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return View.inflate(getActivity(), R.layout.layout_rec, null);
    }

    @Override
    protected void initData() {
        mImageList = new ArrayList<>();
        mImgAdapter = new ImgAdapter(R.layout.item_img, mImageList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView.setAdapter(mImgAdapter);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(4));
        mImgAdapter.setOnItemClickListener(this);
        presenter.getImg(1);
        setListener();

    }

    private void setListener() {
        mImgAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getImg(mImageList.size());
            }
        });


    }

    @Override
    public void showData(List<StaticImgBean.ResBean.VerticalBean> data) {
        mImageList.addAll(data);
        mImgAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showRecyclerView() {

    }

    @Override
    public void refreshFinish() {
        mImgAdapter.loadMoreComplete();
    }

    @Override
    public void refreshFail() {
        mImgAdapter.loadMoreFail();//传入false表示加载失败
    }

    @Override
    public void showNetError(Throwable throwable) {
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
       ImageView imageView = view.findViewById(R.id.iv_imag);
        Intent intent = new Intent(getActivity(), ImagDetailActivity.class);
        intent.putExtra("imgurl", mImageList.get(position).getImg());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 这个是大于等于21  也就是5.0
            Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            intent.putExtra("bitmap",bitmap);
            view.setTransitionName(getActivity().getString(R.string.transition_name));// 这个是一个共同的name  这个name可以随便起  第二个activity中的imageview 的layout中会用到
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                    view, view.getTransitionName());//
            startActivityForResult(intent, 1, options.toBundle());// 这个是固定写法  是startactivityforresult
        } else {
            startActivity(intent);// 当5.0之下 没有这个共享动画  所以直接进入就行
        }

    }

}
