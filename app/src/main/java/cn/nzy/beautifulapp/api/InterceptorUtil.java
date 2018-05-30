package cn.nzy.beautifulapp.api;

import android.util.Log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class InterceptorUtil {
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {  
            @Override  
            public void log(String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    Log.i("aaaa",text+"-----"+message);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置打印数据的级别
    }  
  
    public static Interceptor HeaderInterceptor(){
      return   new Interceptor() {  
            @Override  
            public Response intercept(Chain chain) throws IOException {
                //在这里你可以做一些想做的事,比如token失效时,重新获取token,或者添加header等等
                Request request = chain.request();
                Response originalResponse = chain.proceed(request);
//                Response build = originalResponse.newBuilder().header("token", "123").build();
                return originalResponse;
            }
        };  
  
    }  
}  