package cn.nzy.beautifulapp.mvp.presenter;


import java.util.List;

import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.base.BasePresenter;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.ImgContract;
import cn.nzy.beautifulapp.mvp.model.ImgMudle;
import cn.nzy.beautifulapp.mvp.ui.fragment.ImageFragment;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class ImgPresenter extends BasePresenter<ImgMudle, ImageFragment> implements ImgContract.IImgPresenter  {
    public ImgPresenter(ImageFragment fragment) {
        super(fragment);
    }

    public void  getImg(int page){

            module.getImg(page, new NetLisener<List<StaticImgBean.ResBean.VerticalBean>>() {
                @Override
                public void onSuccess(List<StaticImgBean.ResBean.VerticalBean> imgItemList) {
                    view.showRecyclerView();
                    view.hideProgressBar();
                    view.showData(imgItemList);
                    view.refreshFinish();
                }

                @Override
                public void onFail(Throwable throwable) {
                    view.showNetError(throwable);
                    view.refreshFail();
                }
            });
    };
}
