package cn.nzy.beautifulapp.api;

import cn.nzy.beautifulapp.mvp.NetLisener;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * on 2018/5/25. created by nzy
 */

public class BaseObserver<T> implements Observer<T> {
    private NetLisener<T> mT;
    public BaseObserver(NetLisener<T> t) {
        mT=t;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T o) {
        mT.onSuccess(o);
    }

    @Override
    public void onError(Throwable e) {
        mT.onFail(e);
    }

    @Override
    public void onComplete() {

    }
}
