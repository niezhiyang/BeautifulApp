package cn.nzy.beautifulapp.mvp.model;


import android.support.v4.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
import cn.nzy.beautifulapp.Bean.VedioBean.VedioItemBean;
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


    public VedioMudle(Fragment fragment) {
        super(fragment);
    }

    @Override
    public void getVedio(String max_behot_time, final NetLisener netLisener) {
        HttpHelper.getVedioService().getVedio(max_behot_time)
                .map(new Function<VedioBean, ArrayList<VedioItemBean>>() {
            @Override
            public ArrayList<VedioItemBean> apply(VedioBean vedioBean) throws Exception {
                List<VedioBean.DataBean> data = vedioBean.getData();
                ArrayList<VedioItemBean> vedioItemBeans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    Gson gson = new Gson();
                    VedioItemBean vedioItemBean = gson.fromJson(data.get(i).getContent(), VedioItemBean.class);
                    vedioItemBeans.add(vedioItemBean);
                }
                return vedioItemBeans;
            }
        })
                .compose(RxHelper.<ArrayList<VedioItemBean>>handleResult())
                .subscribe(new Observer<ArrayList<VedioItemBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<VedioItemBean> vedioItemBeans) {
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
