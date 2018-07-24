package cn.nzy.beautifulapp.api;

import java.util.concurrent.TimeUnit;

import cn.nzy.beautifulapp.api.Service.ImgApiService;
import cn.nzy.beautifulapp.api.Service.LivingApiService;
import cn.nzy.beautifulapp.api.Service.VedioApiService;
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
    //手动创建一个OkHttpClient并设置超时时间
    public static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
            // 设置超时时间
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            // 设置读写时间
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .addInterceptor(InterceptorUtil.LogInterceptor())
            .addInterceptor(InterceptorUtil.HeaderInterceptor())
            //设置写入超时时间
            .writeTimeout(10000L, TimeUnit.SECONDS);
    public static OkHttpClient build = okHttpClient.build();
    public static Retrofit.Builder builder = new Retrofit.Builder()
            .client(build)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    private static LivingApiService LIVINGSERVICE;
    private static VedioApiService VEDIOAPISERVICE;
    private static ImgApiService IMGAPISERVICE;

    /**
     * 获取直播的
     */

    public static LivingApiService getLivingService() {
        if (LIVINGSERVICE == null) {
            LIVINGSERVICE = builder.baseUrl(UrlConstant.BASE_LIVING_URL).build().create(LivingApiService.class);
        }
        return LIVINGSERVICE;
    }

    /**
     * 短视频
     */

    public static VedioApiService getVedioService() {
        if (VEDIOAPISERVICE == null) {
            VEDIOAPISERVICE = builder.baseUrl(UrlConstant.BASE_VIDEO_URL).build().create(VedioApiService.class);
        }
        return VEDIOAPISERVICE;
    }
    /**
     * 安卓壁纸
     */

    public static ImgApiService getImgService() {
        if (IMGAPISERVICE == null) {
            IMGAPISERVICE = builder.baseUrl(UrlConstant.BASE_IMG_URL).build().create(ImgApiService.class);
        }
        return IMGAPISERVICE;
    }

}
