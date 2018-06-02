package cn.nzy.beautifulapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nzy.beautifulapp.Bean.TabEntity;
import cn.nzy.beautifulapp.dialog.CardPickerDialog;
import cn.nzy.beautifulapp.mvp.ui.fragment.ImageFragment;
import cn.nzy.beautifulapp.mvp.ui.fragment.LivingFragment;
import cn.nzy.beautifulapp.mvp.ui.fragment.MineFragment;
import cn.nzy.beautifulapp.mvp.ui.fragment.VideoFragment;
import cn.nzy.beautifulapp.util.ThemeHelper;
import cn.nzy.beautifulapp.view.MyBottomTabLayout;

public class StartActivity extends AppCompatActivity implements CardPickerDialog.ClickListener {


    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.mybottomtablayout)
    MyBottomTabLayout mMybottomtablayout;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();

    private String[] mTitles = {"直播", "电影", "图片", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_living_unselect, R.mipmap.tab_video_unselect,
            R.mipmap.tab_img_unselect, R.mipmap.tab_mine_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_living_select, R.mipmap.tab_video_select,
            R.mipmap.tab_img_select, R.mipmap.tab_mine_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        StringBuilder stringBuilder = new StringBuilder();
        mViewpager.setOffscreenPageLimit(4);
    }

    private void initData() {
        Toolbar viewById = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(viewById);
        mFragments.add(new LivingFragment());
        mFragments.add( new VideoFragment());
        mFragments.add( new ImageFragment());
        mFragments.add( new MineFragment());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mViewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mMybottomtablayout.setTabData(mTabEntities);
        mMybottomtablayout.setTabData(mTabEntities);
        mMybottomtablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme) {
            CardPickerDialog dialog = new CardPickerDialog();
            dialog.setClickListener(this);
            dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ThemeUtils.getColorById(this, R.color.theme_color_primary_dark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    ThemeUtils.getThemeAttrColor(this, android.R.attr.colorPrimary));
            setTaskDescription(description);
        }
    }

    @Override
    public void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(StartActivity.this) != currentTheme) {
            ThemeHelper.setTheme(StartActivity.this, currentTheme);
            ThemeUtils.refreshUI(StartActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final StartActivity context = StartActivity.this;
                                ActivityManager.TaskDescription taskDescription =
                                        new ActivityManager.TaskDescription(null, null,
                                                ThemeUtils.getThemeAttrColor(context, android.R.attr.colorPrimary));
                                setTaskDescription(taskDescription);
                                getWindow().setStatusBarColor(
                                        ThemeUtils.getColorById(context, R.color.theme_color_primary_dark));
                            }
                        }

                        @Override
                        public void refreshSpecificView(View view) {
                            //TODO: will do this for each traversal
                        }
                    }
            );
        }
    }
}
