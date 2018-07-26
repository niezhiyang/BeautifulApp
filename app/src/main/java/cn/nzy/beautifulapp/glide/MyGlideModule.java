package cn.nzy.beautifulapp.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import okhttp3.OkHttpClient;

@com.bumptech.glide.annotation.GlideModule
public class MyGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new ProgressInterceptor());
        builder.addInterceptor(new ProgressInterceptor());
        OkHttpClient okHttpClient = builder.build();
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
    }
    //    @Override
//    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
////        builder.addInterceptor(new ProgressInterceptor());
//        builder.addInterceptor(new ProgressInterceptor());
//        builder .addInterceptor(InterceptorUtil.LogInterceptor());
//        OkHttpClient okHttpClient = builder.build();
//        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
//    }
}


//    @Override
//    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
////        builder.addInterceptor(new ProgressInterceptor());
//        builder.addInterceptor(new ProgressInterceptor());
//        builder .addInterceptor(InterceptorUtil.LogInterceptor());
//        OkHttpClient okHttpClient = builder.build();
//        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
//    }
//
//    @Override
//    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
//
//    }
//}