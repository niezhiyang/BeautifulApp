package cn.nzy.beautifulapp.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.CategoryBeanDao;
import cn.nzy.beautifulapp.MyApplication;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.mvp.ui.ChannelActivity;
import cn.nzy.beautifulapp.mvp.ui.HomeLazyFragment;

/**
 * on 2018/5/21. created by nzy
 */

public class LivingFragment extends Fragment {
    @BindView(R.id.slidingtablayout)
    SlidingTabLayout mSlidingtablayout;
    @BindView(R.id.vp_video)
    ViewPager mVpVideo;
    Unbinder unbinder;
    private List<CategoryBean> mIfoEntities;
    private List<Fragment> mFragments;
    private MyPagerAdapter mAdapter;

    // 1是一选择的   0 是 other
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup inflate = (ViewGroup) View.inflate(getActivity(), R.layout.fragment_living, null);
        mIfoEntities = MyApplication.getInstances().getDaoSession().getCategoryBeanDao().queryBuilder().where(CategoryBeanDao.Properties.Type.eq(1)).orderDesc(CategoryBeanDao.Properties.Sort).build().list();
        unbinder = ButterKnife.bind(this, inflate);
        mFragments = new ArrayList<>();
        for (CategoryBean s : mIfoEntities) {
            mFragments.add(HomeLazyFragment.newInstance(s));
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mVpVideo.setAdapter(mAdapter);
        mSlidingtablayout.setViewPager(mVpVideo);
        EventBus.getDefault().register(this);
        return inflate;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(List<CategoryBean> infoEntities) {
        mIfoEntities=infoEntities;
        mFragments = new ArrayList<>();
        for (CategoryBean s : mIfoEntities) {
            mFragments.add(HomeLazyFragment.newInstance(s));
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mVpVideo.setAdapter(mAdapter);
        mSlidingtablayout.setViewPager(mVpVideo);
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.iv_select_channel)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), ChannelActivity.class);
        startActivity(intent);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mIfoEntities.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mIfoEntities.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }


}
