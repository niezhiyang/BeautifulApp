package cn.nzy.beautifulapp.mvp;


/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public interface NetLisener<T> {
    void onSuccess(T list);
    void onFail(Throwable throwable);
}
