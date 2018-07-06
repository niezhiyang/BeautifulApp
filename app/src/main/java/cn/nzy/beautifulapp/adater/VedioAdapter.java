package cn.nzy.beautifulapp.adater;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.nzy.beautifulapp.Bean.VedioBean.VedioBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.utils.GlideUtil;

public class VedioAdapter extends BaseQuickAdapter<VedioBean.ResultBean, BaseViewHolder> {
    public VedioAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VedioBean.ResultBean item) {
        helper.setText(R.id.tv_author, item.getTitle());
        JZVideoPlayerStandard jzView = (JZVideoPlayerStandard) helper.getView(R.id.videoplayer);
        jzView.setUp(item.getUrl()+"", JZVideoPlayer.SCREEN_WINDOW_LIST,
                item.getTitle());
        GlideUtil.setImage(mContext,item.getScreenshot_url(),jzView.thumbImageView);
    }

}
