package cn.nzy.beautifulapp.mvp.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.base.BaseLazyFragment;


public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<HomeLazyFragment> fragmentList = new ArrayList<>();

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void init(List<CategoryBean> list) {
        fragmentList.clear();
        for (CategoryBean info : list) {
            fragmentList.add(HomeLazyFragment.newInstance(info));
        }
    }

    public void refreshAllFragment(List<CategoryBean> list) {
        for (CategoryBean info : list) {
            for (HomeLazyFragment fragment : fragmentList) {
                String pageTitle = fragment.getTitle();
                if (pageTitle != null && pageTitle.equals(info.getName())) {
                    fragment.refreshData(info);
                }
            }
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentList != null && position < fragmentList.size()) {
            return fragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (getItem(position) instanceof BaseLazyFragment) {
            return ((BaseLazyFragment) getItem(position)).getTitle();
        }
        return super.getPageTitle(position);
    }
}