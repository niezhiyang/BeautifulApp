package cn.nzy.beautifulapp.adater;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.nzy.beautifulapp.Bean.VedioBean.VedioItemBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.utils.GlideUtil;

public class VedioAdapter extends BaseQuickAdapter<VedioItemBean, BaseViewHolder> {
    public VedioAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VedioItemBean item) {
        helper.setText(R.id.item_vedio_name, item.getTitle());
        helper.setText(R.id.item_vedio_title, item.getTitle());
//        helper.setText(R.id.item_vedio_view, item.get());
//        helper.setText(R.id.item_vedio_view, item.getVideo_id());
        JZVideoPlayerStandard jzView = (JZVideoPlayerStandard) helper.getView(R.id.videoplayer);
        jzView.setUp(item.getDisplay_url(), JZVideoPlayer.SCREEN_WINDOW_LIST,
                item.getTitle());
        GlideUtil.setImage(mContext,item.getLarge_image_list().get(0).getUrl(),jzView.thumbImageView);
//        helper.setText(R.id.text, item.getTitle());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
        GlideUtil.setImage(mContext, item.getMiddle_image().getUrl(), (ImageView)helper.getView(R.id.item_vedio_avatar));



    }

}
