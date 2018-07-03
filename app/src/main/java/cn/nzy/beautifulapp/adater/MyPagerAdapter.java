package cn.nzy.beautifulapp.adater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.nzy.beautifulapp.Bean.CategoryBean;

public class MyPagerAdapter extends FragmentPagerAdapter {
    List<Fragment>mFragments;
    List<CategoryBean> mTitles;
        public MyPagerAdapter(FragmentManager fm, List<Fragment>fragments, List<CategoryBean> title ) {
            super(fm);
            mFragments = fragments;
            mTitles=title;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position).getName();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }