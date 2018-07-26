package cn.nzy.beautifulapp.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cn.nzy.beautifulapp.R;


/**
 * on 2018/1/3.
 * created by niezhiyang
 */

public class GlideUtil {
    public static RequestOptions options = new RequestOptions()
            .placeholder(R.mipmap.live_default)
            .error(R.mipmap.live_default);
    public static RequestOptions optionsImage = new RequestOptions()
            .placeholder(R.mipmap.default_detail)
            .error(R.mipmap.default_detail);

    public static void setImage(Fragment fragment, String url, ImageView imageView) {

        Glide.with(fragment)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void setImage(Context context, String url, ImageView imageView) {

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void setImageDetail(Activity context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(optionsImage)
                .into(imageView);
    }

    public static void setImageDetail(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(optionsImage)
                .into(imageView);
    }

    public static void setImageDetail(Context context, Bitmap bitmap, ImageView imageView) {

        Glide.with(context)
                .load(bitmap)
                .apply(optionsImage)
                .into(imageView);
    }

}
