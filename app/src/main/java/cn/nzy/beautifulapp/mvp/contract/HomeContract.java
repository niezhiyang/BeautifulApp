package cn.nzy.beautifulapp.mvp.contract;


import java.util.List;

import cn.nzy.beautifulapp.Bean.livingBean.LivingBean;
import cn.nzy.beautifulapp.base.BaseContract;
import cn.nzy.beautifulapp.mvp.NetLisener;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeContract {
    public interface IHomePresenter extends BaseContract.IBasePresenter  {

    }

    public interface IHomeView extends BaseContract.IBaseView {
        void showData(List<LivingBean.DataBean> data);
        void hideProgressBar();
        void showRecyclerView();
        void goActivity();
        void reFresh();
        void loadMore();
        void showBanner(List<LivingBean.BigsquareBean> bigsquareBeans);
        void hideBanner();
    }
    public interface IHomeModule extends BaseContract.IBaseModule {
        void getNetData(String category, NetLisener netLisener);
    }
}
