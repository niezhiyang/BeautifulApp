package cn.nzy.beautifulapp.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import cn.nzy.beautifulapp.R;


/**
 * on 2018/1/3.
 * created by niezhiyang
 */

public class GlideUtil {
    public static RequestOptions options = new RequestOptions()
            .placeholder(R.mipmap.live_default)
            .error(R.mipmap.live_default)
            .diskCacheStrategy(DiskCacheStrategy.NONE);
    public static void setImage(Fragment fragment, String url, ImageView imageView){

        Glide.with(fragment)
                .load(url)
                .apply(options)
                .into(imageView);
    }
    public static void setImage(Context context, String url, ImageView imageView){

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
