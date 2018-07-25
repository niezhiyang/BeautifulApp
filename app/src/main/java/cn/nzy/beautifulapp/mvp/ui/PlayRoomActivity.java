package cn.nzy.beautifulapp.mvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nzy.beautifulapp.Bean.livingBean.PlayRoom;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.base.BaseActivity;
import cn.nzy.beautifulapp.base.BaseModule;
import cn.nzy.beautifulapp.mvp.contract.PlayRoomContract;
import cn.nzy.beautifulapp.mvp.model.PlayRoomMudle;
import cn.nzy.beautifulapp.mvp.presenter.PlayRoomPresenter;
import cn.nzy.beautifulapp.view.StandardVideoController;

/**
 * on 2018/6/2.
 * created by niezhiyang
 */
public class PlayRoomActivity extends BaseActivity<PlayRoomContract.IPlayRoomView, PlayRoomPresenter> implements PlayRoomContract.IPlayRoomView {
    @BindView(R.id.player)
    IjkVideoView mPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_room);
        ButterKnife.bind(this);
        String uid = getIntent().getStringExtra("uid");
        presenter.getNetData(uid);
        Intent intent = getIntent();
        if (intent != null) {
            StandardVideoController controller = new StandardVideoController(this);
            boolean isLive = intent.getBooleanExtra("isLive", true);
            if (isLive) {
                controller.setLive();
            }
            mPlayer.setPlayerConfig(new PlayerConfig.Builder()
                    .autoRotate()//自动旋转屏幕
//                    .enableCache()//启用边播边存
//                    .enableMediaCodec()//启动硬解码
//                    .usingSurfaceView()//使用SurfaceView
//                    .setCustomMediaPlayer(new ExoMediaPlayer(this))
//                    .setCustomMediaPlayer(new AndroidMediaPlayer(this))
                    .build());
//            ijkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
            mPlayer.setVideoController(controller);

        }
    }

    @Override
    protected PlayRoomPresenter setPresenter() {
        return new PlayRoomPresenter(this);
    }

    @Override
    protected BaseModule setModule() {
        return new PlayRoomMudle();
    }

    @Override
    public void showData(PlayRoom data) {
        PlayRoom.LiveBean.WsBean.FlvBean flv = data.getLive().getWs().getFlv();
        String playUrl = "";
        if (flv.get_$5() != null) {
            playUrl = flv.get_$5().getSrc();
        } else if(flv.get_$4() != null){
            playUrl = flv.get_$4().getSrc();
        }else if(flv.get_$3() != null){
            playUrl = flv.get_$3().getSrc();
        }
        mPlayer.setUrl(playUrl);
        mPlayer.start();
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showNetError(Throwable throwable) {
        ToastUtils.showShort(throwable.toString());
    }
    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayer.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }


    @Override
    public void onBackPressed() {
        if (!mPlayer.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
