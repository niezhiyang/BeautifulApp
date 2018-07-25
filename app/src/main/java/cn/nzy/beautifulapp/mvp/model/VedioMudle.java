package cn.nzy.beautifulapp.mvp.model;


import java.util.List;

import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
import cn.nzy.beautifulapp.api.HttpHelper;
import cn.nzy.beautifulapp.api.RxHelper;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.VedioContract;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class VedioMudle extends BaseModule implements VedioContract.IVedioModule {
    private String[] urlpage = {
            "1/466a5e7f4d429cb68e1d404c485b943f",
            "2/9a8fc3e7fd4d0b9578d306ed5e461548",
            "3/fa66d2ef099717484524ad72351f2c6e",
            "4/accb30074dcb6352024a6cb22f5e2f0d",
            "5/3c2cd97082d1a9083749094b77b8b80c",
            "6/2a571e25b79882257073210b883fd472",
            "7/d6d1a7366315ea88723bf78193a3e537",
            "8/511dcfeedc675986f1466ae56d0f2f4a",
            "9/2ad17c577ccd58e2a18cecd9107709a3",
            "10/b309b48c7c20b2968b2c0a59ef64aca7",
            "11/b8b876617c3c9cab56c5797d8f30f0f5",
            "12/b5c49d4b1eae4a039eb47992163dcd11",
            "13/8f36a0eeaf566575cdb9780632a3b947",
    };



    @Override
    public void getVedio(int page, final NetLisener netLisener) {
        HttpHelper.getVedioService().getVedio(page+1+"",urlpage[page].substring(2))
                .map(new Function<VedioBean, List<VedioBean.ResultBean>>() {
                    @Override
                    public List<VedioBean.ResultBean> apply(VedioBean vedioBean) throws Exception {
                        List<VedioBean.ResultBean> result = vedioBean.getResult();
                        return result;
                    }
                })
                .compose(RxHelper.<List<VedioBean.ResultBean>>handleResult())
                .subscribe(new Observer<List<VedioBean.ResultBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<VedioBean.ResultBean> vedioItemBeans) {
                        netLisener.onSuccess(vedioItemBeans);
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
