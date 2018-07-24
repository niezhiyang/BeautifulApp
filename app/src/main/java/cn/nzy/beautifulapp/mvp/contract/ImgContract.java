package cn.nzy.beautifulapp.mvp.contract;


import java.util.List;

import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.base.BaseContract;
import cn.nzy.beautifulapp.mvp.NetLisener;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class ImgContract {
    public interface IImgPresenter extends BaseContract.IBasePresenter  {

    }

    public interface IImgView extends BaseContract.IBaseView {
        void showData(List<StaticImgBean.ResBean.VerticalBean> data);
        void hideProgressBar();
        void showRecyclerView();
        void refreshFinish();
        void refreshFail();
    }
    public interface IImgModule extends BaseContract.IBaseModule {
        void getImg(int SkipId, NetLisener netLisener);
    }
}
