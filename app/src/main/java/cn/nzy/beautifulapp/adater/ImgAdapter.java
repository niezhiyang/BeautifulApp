package cn.nzy.beautifulapp.adater;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.nzy.beautifulapp.Bean.imgBean.StaticImgBean;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.utils.GlideUtil;

public class ImgAdapter extends BaseQuickAdapter<StaticImgBean.ResBean.VerticalBean, BaseViewHolder> {
    public ImgAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StaticImgBean.ResBean.VerticalBean item) {
        ImageView view = (ImageView) helper.getView(R.id.iv_imag);
        GlideUtil.setImageDetail(mContext,item.getImg(),(ImageView) helper.getView(R.id.iv_imag));
    }

}
