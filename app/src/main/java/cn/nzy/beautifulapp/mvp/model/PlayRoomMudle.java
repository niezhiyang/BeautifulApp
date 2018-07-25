package cn.nzy.beautifulapp.mvp.model;


import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
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

public class PlayRoomMudle extends BaseModule implements HomeContract.IHomeModule {



    @Override
    public void getNetData(String uid, final NetLisener netLisener) {
        Observable<PlayRoom> playRoom = HttpHelper.getLivingService().getPlayRoom(uid);
        playRoom.compose(RxHelper.<PlayRoom>handleResult()).subscribe(new BaseObserver(netLisener));
    }

}
