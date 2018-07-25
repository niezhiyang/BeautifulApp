package cn.nzy.beautifulapp.mvp.presenter;


import java.util.List;

import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
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
    public VedioPresenter(VideoFragment fragment) {
        super(fragment);
    }

    public void  getVedio(int page){

            module.getVedio(page, new NetLisener<List<VedioBean.ResultBean>>() {
                @Override
                public void onSuccess(List<VedioBean.ResultBean> vedioItemBeans) {
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
