package cn.nzy.beautifulapp.api;

import java.util.concurrent.TimeUnit;

import cn.nzy.beautifulapp.constant.UrlConstant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * on 2017/12/21.
 * 类的描述:
 */

public class HttpHelper {
    private static ApiService SERVICE;

    /**
     * 请求超时时间
     */

    public static ApiService getDefault() {
        if (SERVICE == null) {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    // 设置超时时间
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    // 设置读写时间
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
                    //设置写入超时时间
                    .writeTimeout(10000L, TimeUnit.SECONDS);

//            // 拦截请求头 . 重新获取token 等操作
//            okHttpClient.addInterceptor(InterceptorUtil.HeaderInterceptor());
//            //添加日志拦截器
//            okHttpClient.addInterceptor(InterceptorUtil.LogInterceptor());
//            //添加日志拦截器
//            okHttpClient.addNetworkInterceptor(new StethoInterceptor());

            OkHttpClient build = okHttpClient.build();
            SERVICE = new Retrofit.Builder()
                    .client(build)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(UrlConstant.BASE_LIVING_URL)
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }
}
