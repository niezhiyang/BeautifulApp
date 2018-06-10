package cn.nzy.beautifulapp.mvp.model;


import android.support.v7.app.AppCompatActivity;

import cn.nzy.beautifulapp.Bean.LivingBean.PlayRoom;
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


    public PlayRoomMudle(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void getNetData(String uid, final NetLisener netLisener) {
        Observable<PlayRoom> playRoom = HttpHelper.getDefault().getPlayRoom(uid);
        playRoom.compose(RxHelper.<PlayRoom>handleResult()).subscribe(new BaseObserver(netLisener));
    }

}
