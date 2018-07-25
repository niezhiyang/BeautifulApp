package cn.nzy.beautifulapp.mvp.presenter;


import cn.nzy.beautifulapp.Bean.livingBean.LivingBean;
import cn.nzy.beautifulapp.base.BasePresenter;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.HomeContract;
import cn.nzy.beautifulapp.mvp.model.HomeMudle;
import cn.nzy.beautifulapp.mvp.ui.HomeLazyFragment;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomePresenter extends BasePresenter<HomeMudle, HomeLazyFragment> implements HomeContract.IHomePresenter  {
    public HomePresenter(HomeLazyFragment fragment) {
        super(fragment);
    }

    public void  getNetData(String category){

            module.getNetData(category, new NetLisener<LivingBean>() {
                @Override
                public void onSuccess(LivingBean netData) {
                    view.showRecyclerView();
                    view.hideProgressBar();
                    // 如果不等于null 证明有banner
                    if (netData.getBigsquare() != null&&netData.getBigsquare().size()>0) {
                        view.showBanner(netData.getBigsquare());
                    } else {
                        // 证明没有banner 去掉header
                        view.hideBanner();
                    }
                    view.showData(netData.getData());

                }

                @Override
                public void onFail(Throwable throwable) {
                    view.showNetError(throwable);
                }
            });
    };
}
