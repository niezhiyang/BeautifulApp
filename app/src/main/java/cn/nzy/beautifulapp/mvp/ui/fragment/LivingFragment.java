package cn.nzy.beautifulapp.mvp.ui.fragment;

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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.LivingBean.Bean;
import cn.nzy.beautifulapp.Bean.LivingBean.CategoriesBean;
import cn.nzy.beautifulapp.R;
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
    private List<CategoryBean> infoEntities = new ArrayList<>();
    private List<Fragment> mFragments;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup inflate = (ViewGroup) View.inflate(getActivity(), R.layout.fragment_video, null);

        unbinder = ButterKnife.bind(this, inflate);
        mFragments = new ArrayList<>();
        String data = Bean.s;
        Gson gson = new Gson();
        CategoriesBean categoriesBean = gson.fromJson(data, CategoriesBean.class);
        List<CategoriesBean.DataBean> data1 = categoriesBean.getData();
        for (int i = 0;  i < data1.size();i++) {
            CategoriesBean.DataBean dataBean = data1.get(i);
            CategoryBean categoryBean = changCategoryBean(dataBean);
            infoEntities.add(categoryBean);
            mFragments.add(HomeLazyFragment.newInstance(categoryBean));
        }
      MyPagerAdapter mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mVpVideo.setAdapter(mAdapter);
        mSlidingtablayout.setViewPager(mVpVideo);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return infoEntities.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return infoEntities.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
    private CategoryBean changCategoryBean(CategoriesBean.DataBean dataBean) {
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setName(dataBean.getName());
        categoryBean.setSlug(dataBean.getSlug());
        return categoryBean;
    }
}
