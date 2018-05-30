package cn.nzy.beautifulapp.view;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by chengli on 15/6/8.
 */
public class ViewAttributeUtil {

    public static int getAttributeValue(AttributeSet attr, int paramInt) {
        int value = -1;
        int count = attr.getAttributeCount();
        for (int i = 0; i < count; i++) {
            if (attr.getAttributeNameResource(i) == paramInt) {
                String str = attr.getAttributeValue(i);
//                if (null != str) {
                if (null != str && (str.startsWith("?") || paramInt == android.R.attr.src || paramInt == android.R.attr.background)) {
                    //因为要动态改图片，图片没有用自定义属性
                    value = getValue(str);
                    return value;
                }
            }
        }
        return value;
    }

    public static int getAttributeValue(AttributeSet attr, String nameSpace, String name) {
        int value = -1;
        String str = attr.getAttributeValue(nameSpace, name);
        if (null != str && (str.startsWith("?"))) {
            value = getValue(str);
        }
        return value;
    }


    public static int getValue(String value) {
        return Integer.valueOf(value.substring(1, value.length())).intValue();
    }

    public static int getBackgroundAttibute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.background);
    }

    public static int getCheckMarkAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.checkMark);
    }

    public static int getSrcAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.src);
    }

    public static int getTextApperanceAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.textAppearance);
    }

    public static int getDrawableTopAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.drawableTop);
    }

    public static int getDividerAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.divider);
    }

    public static int getTextColorAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.textColor);
    }

    public static void applyBackgroundDrawable(ColorUiInterface ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        Drawable drawable = ta.getDrawable(0);
        if (null != ci) {
            (ci.getView()).setBackgroundDrawable(drawable);
        }
        ta.recycle();
    }


    public static void applyTextAppearance(ColorUiInterface ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        int resourceId = ta.getResourceId(0, 0);
        if (null != ci && ci instanceof TextView) {
            ((TextView) ci.getView()).setTextAppearance(ci.getView().getContext(), resourceId);
        }
        ta.recycle();
    }

    public static void applyTextColor(ColorUiInterface ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        int resourceId = ta.getColor(0, 0);
        if (null != ci && ci instanceof TextView) {
            ((TextView) ci.getView()).setTextColor(resourceId);
        }
        ta.recycle();
    }


}
