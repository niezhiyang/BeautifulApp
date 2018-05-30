package cn.nzy.beautifulapp.mvp.model;


import android.support.v4.app.Fragment;

import cn.nzy.beautifulapp.Bean.LivingBean.LivingBean;
import cn.nzy.beautifulapp.api.BaseObserver;
import cn.nzy.beautifulapp.api.HttpHelper;
import cn.nzy.beautifulapp.api.RxHelper;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.HomeContract;
import io.reactivex.Observable;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class HomeMudle extends BaseModule implements HomeContract.IHomeModule {


    public HomeMudle(Fragment fragment) {
        super(fragment);
    }

    @Override
    public void getNetData(String category, final NetLisener netLisener) {
        Observable<LivingBean> liveListResultByCategories = HttpHelper.getDefault().getLiveListResultByCategories(category);
        liveListResultByCategories.compose(RxHelper.<LivingBean>handleResult()).subscribe(new BaseObserver(netLisener));
    }

}
