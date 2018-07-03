package cn.nzy.beautifulapp.mvp.presenter;


import java.util.ArrayList;

import cn.nzy.beautifulapp.Bean.VedioBean.VedioItemBean;
import cn.nzy.beautifulapp.base.BasePresenter;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.VedioContract;
import cn.nzy.beautifulapp.mvp.model.VedioMudle;
import cn.nzy.beautifulapp.mvp.ui.fragment.VideoFragment;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class VedioPresenter extends BasePresenter<VedioMudle, VideoFragment> implements VedioContract.IVedioPresenter  {
    public void  getVedio(String max_behot_time){

            module.getVedio(max_behot_time, new NetLisener<ArrayList<VedioItemBean>>() {
                @Override
                public void onSuccess(ArrayList<VedioItemBean> vedioItemBeans) {
                    view.showRecyclerView();
                    view.hideProgressBar();
                    view.showData(vedioItemBeans);

                }

                @Override
                public void onFail(Throwable throwable) {
                    view.showNetError(throwable);
                }
            });
    };
}
