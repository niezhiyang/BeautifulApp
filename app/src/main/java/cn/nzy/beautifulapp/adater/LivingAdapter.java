package cn.nzy.beautifulapp.adater;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.nzy.beautifulapp.Bean.livingBean.LivingBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.glide.GlideUtil;

public class LivingAdapter extends BaseQuickAdapter<LivingBean.DataBean, BaseViewHolder> {
    private Fragment mFragment;
    public LivingAdapter(int layoutResId, List data, Fragment fragment) {
        super(layoutResId, data);
        mFragment=fragment;
    }

    @Override
    protected void convert(BaseViewHolder helper, LivingBean.DataBean item) {
        helper.setText(R.id.item_living_name, item.getNick());
        helper.setText(R.id.item_living_title, item.getTitle());
        helper.setText(R.id.item_living_view, item.getView());
//        helper.setText(R.id.text, item.getTitle());
//        helper.setImageResource(R.id.icon, item.getImageResource());
//        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
        GlideUtil.setImage(mFragment, item.getThumb(), (ImageView)helper.getView(R.id.item_living_img));
        GlideUtil.setImage(mFragment, item.getAvatar(), (ImageView)helper.getView(R.id.item_living_avatar));



    }

}
