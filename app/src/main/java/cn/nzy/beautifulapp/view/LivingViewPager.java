package cn.nzy.beautifulapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * on 2018/5/22. created by nzy
 */

public class LivingViewPager extends ViewPager {

    private int startX;
    private int startY;

    public LivingViewPager(@NonNull Context context) {
        super(context);
    }

    public LivingViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //不让父亲拦截我的滑动事件
        getParent().requestDisallowInterceptTouchEvent(true);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                int endX = (int) ev.getX();
                int endY = (int) ev.getY();

                int dx = endX - startX;
                int dy = endY - startY;

                if (Math.abs(dy) < Math.abs(dx)) {
                    int currentItem = getCurrentItem();
                    // 左右滑动
                    if (dx > 0) {
                        // 向右划
                        if (currentItem == 0) {
                            // 第一个页面,需要拦截
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        // 向左划
                        int count = getAdapter().getCount();// item总数
                        if (currentItem == count - 1) {
                            // 最后一个页面,需要拦截
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }

                } else {
                    // 上下滑动,需要拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                break;

            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
