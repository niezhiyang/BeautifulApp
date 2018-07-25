package cn.nzy.beautifulapp.mvp.presenter;

import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import cn.nzy.beautifulapp.base.BasePresenter;
import cn.nzy.beautifulapp.mvp.NetLisener;
import cn.nzy.beautifulapp.mvp.contract.PlayRoomContract;
import cn.nzy.beautifulapp.mvp.model.PlayRoomMudle;
import cn.nzy.beautifulapp.mvp.ui.PlayRoomActivity;

/**
 * on 2018/6/2.
 * created by niezhiyang
 */
public class PlayRoomPresenter extends BasePresenter<PlayRoomMudle, PlayRoomActivity> implements PlayRoomContract.IPlayRoomPresenter {
    public PlayRoomPresenter(PlayRoomActivity fragment) {
        super(fragment);
    }

    public void getNetData(String uid) {

        module.getNetData(uid, new NetLisener<PlayRoom>() {
            @Override
            public void onSuccess(PlayRoom netData) {
                view.hideProgressBar();
                view.showData(netData);

            }

            @Override
            public void onFail(Throwable throwable) {
                view.showNetError(throwable);
            }
        });

    }
}