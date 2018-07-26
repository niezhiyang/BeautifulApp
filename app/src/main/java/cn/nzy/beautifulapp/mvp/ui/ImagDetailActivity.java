package cn.nzy.beautifulapp.mvp.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.glide.GlideUtil;
import cn.nzy.beautifulapp.glide.ProgressInterceptor;
import cn.nzy.beautifulapp.glide.ProgressListener;
import cn.nzy.beautifulapp.view.CircleProgressView;

public class ImagDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_imag_detail)
    ImageView mIvImagDetail;
    @BindView(R.id.pv_iv_detail)
    CircleProgressView mCircleProgressView;
    int mCurrentProgress = 0;
    int mTotalProgress = 100;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Glide.with(ImagDetailActivity.this).load(mImgurl).into(mIvImagDetail);
            Bitmap bitmap = (Bitmap) msg.obj;
            Drawable drawable = new BitmapDrawable(bitmap);
            RequestOptions optionsImage = new RequestOptions()
                    .placeholder(drawable)
                    .error(drawable).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            ProgressInterceptor.addListener(mImgurl, new ProgressListener() {
                @Override
                public void onProgress(int progress) {
                    Log.e("download",progress+"");
                }
            });
            Glide.with(ImagDetailActivity.this).load(mImgurl).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    ProgressInterceptor.removeListener(mImgurl);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    Log.e("download是否第一次",isFirstResource+"---"+model+"----"+dataSource);
                    ProgressInterceptor.removeListener(mImgurl);
                    return false;
                }
            }).into(mIvImagDetail);
        }
    };
    private String mImgurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imag_detail);
        ButterKnife.bind(this);
        mImgurl = getIntent().getStringExtra("imgurl");
        Bitmap bitmap = getIntent().getParcelableExtra("bitmap");
        Log.e("wwwww", bitmap.getRowBytes() * bitmap.getHeight() + "");
        Message message = Message.obtain();
        message.obj = bitmap;
        mHandler.sendMessageDelayed(message, 1000);
        GlideUtil.setImageDetail(this, bitmap, mIvImagDetail);
    }
}
