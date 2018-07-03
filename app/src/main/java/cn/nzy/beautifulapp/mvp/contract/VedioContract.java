package cn.nzy.beautifulapp.mvp.contract;


import java.util.List;

import cn.nzy.beautifulapp.Bean.VedioBean.VedioItemBean;
import cn.nzy.beautifulapp.base.BaseContract;
import cn.nzy.beautifulapp.mvp.NetLisener;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class VedioContract {
    public interface IVedioPresenter extends BaseContract.IBasePresenter  {

    }

    public interface IVedioView extends BaseContract.IBaseView {
        void showData(List<VedioItemBean> data);
        void hideProgressBar();
        void showRecyclerView();
        void refreshFinish();
        void refreshFail();
    }
    public interface IVedioModule extends BaseContract.IBaseModule {
        void getVedio(String max_behot_time, NetLisener netLisener);
    }
}
