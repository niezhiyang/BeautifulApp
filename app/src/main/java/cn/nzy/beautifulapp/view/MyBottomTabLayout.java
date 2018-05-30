package cn.nzy.beautifulapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.bilibili.magicasakura.utils.TintManager;
import com.bilibili.magicasakura.widgets.Tintable;
import com.flyco.tablayout.CommonTabLayout;

import cn.nzy.beautifulapp.R;

/**
 * on 2018/5/22. created by nzy
 */

public class MyBottomTabLayout extends CommonTabLayout implements Tintable, AppCompatBackgroundHelper.BackgroundExtensible {
    private AppCompatBackgroundHelper mBackgroundHelper;

    public MyBottomTabLayout(Context context) {
        this(context, null);
    }

    public MyBottomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public MyBottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        @SuppressLint("RestrictedApi") TintManager mTintManager = TintManager.get(getContext());

        mBackgroundHelper = new AppCompatBackgroundHelper(this, mTintManager);
        mBackgroundHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundDrawableExternal(background);
        }
    }

    @Override
    public void setBackgroundResource(int resId) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundResId(resId);
        } else {
            super.setBackgroundResource(resId);
        }
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundColor(color);
        }
    }

    @Override
    public void setBackgroundTintList(int resId) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundTintList(resId, null);
        }
    }

    @Override
    public void setBackgroundTintList(int resId, PorterDuff.Mode mode) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundTintList(resId, mode);
        }
    }


    @Override
    public void tint() {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.tint();
        }
    }

}