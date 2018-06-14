package cn.nzy.beautifulapp.mvp.contract;


import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import cn.nzy.beautifulapp.base.BaseContract;
import cn.nzy.beautifulapp.mvp.NetLisener;

/**
 * on 2018/1/2.
 * created by niezhiyang
 */

public class PlayRoomContract {
    public interface IPlayRoomPresenter extends BaseContract.IBasePresenter  {

    }

    public interface IPlayRoomView extends BaseContract.IBaseView {
        void showData(PlayRoom data);
        void hideProgressBar();
    }
    public interface IPlayRoomModule extends BaseContract.IBaseModule {
        void getNetData(String uid, NetLisener netLisener);
    }
}
