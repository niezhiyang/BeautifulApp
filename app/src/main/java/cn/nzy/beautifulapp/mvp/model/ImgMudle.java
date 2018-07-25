package cn.nzy.beautifulapp.mvp.model;


import java.util.List;

import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.api.HttpHelper;
import cn.nzy.beautifulapp.api.RxHelper;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.ImgContract;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class ImgMudle extends BaseModule implements ImgContract.IImgModule {



    @Override
    public void getImg(int skipId, final NetLisener netLisener) {
        HttpHelper.getImgService().getStaticImgByCategory(skipId)
                .map(new Function<StaticImgBean, List<StaticImgBean.ResBean.VerticalBean>>() {
                    @Override
                    public List<StaticImgBean.ResBean.VerticalBean> apply(StaticImgBean staticImgBean) throws Exception {
                        return staticImgBean.getRes().getVertical();
                    }
                }).compose(RxHelper.<List<StaticImgBean.ResBean.VerticalBean>>handleResult()).subscribe(new Observer<List<StaticImgBean.ResBean.VerticalBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<StaticImgBean.ResBean.VerticalBean> verticalBeans) {
                netLisener.onSuccess(verticalBeans);
            }

            @Override
            public void onError(Throwable e) {
                netLisener.onFail(e);
            }

            @Override
            public void onComplete() {

            }
        });


    }

}
