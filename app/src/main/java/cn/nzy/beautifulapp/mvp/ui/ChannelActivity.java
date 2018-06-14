package cn.nzy.beautifulapp.mvp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.nzy.beautifulapp.Bean.CategoryBean;
import cn.nzy.beautifulapp.Bean.CategoryBeanDao;
import cn.nzy.beautifulapp.MyApplication;
import cn.nzy.beautifulapp.R;
import cn.nzy.beautifulapp.adater.ChannelAdapter;
import cn.nzy.beautifulapp.util.channelhelper.ItemDragHelperCallback;

public class ChannelActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.recy)
    RecyclerView mRecy;
    @BindView(R.id.fb_channle)
    FloatingActionButton mFbChannle;
    private List<CategoryBean> mMyChannelItems;
    private List<CategoryBean> mOtherItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        ButterKnife.bind(this);

        mRecy = (RecyclerView) findViewById(R.id.recy);
        mFbChannle.setOnClickListener(this);
        init();
    }

    private void init() {
        mMyChannelItems = MyApplication.getInstances().getDaoSession().queryBuilder(CategoryBean.class).where(CategoryBeanDao.Properties.Type.eq(1)).orderDesc(CategoryBeanDao.Properties.Sort).build().list();
        mOtherItems = MyApplication.getInstances().getDaoSession().queryBuilder(CategoryBean.class).where(CategoryBeanDao.Properties.Type.eq(0)).orderDesc(CategoryBeanDao.Properties.Sort).build().list();
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, mMyChannelItems, mOtherItems);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY || viewType == ChannelAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        mRecy.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ChannelActivity.this, mMyChannelItems.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnPositiveListener(new ChannelAdapter.OnItemMoveFinsh() {
            @Override
            public void onItemFinish(List<CategoryBean> myChannelItems, List<CategoryBean> otherChannelItems) {
                // 每次移动 都重新记录到数据库中
                for (int i = 0; i < myChannelItems.size(); i++) {
                    CategoryBean categoryBean = myChannelItems.get(i);
                    categoryBean.setType(1);
                    categoryBean.setSort(myChannelItems.size() - i);
                    MyApplication.getInstances().getDaoSession().getCategoryBeanDao().save(categoryBean);
                }
                for (int i = 0; i < otherChannelItems.size(); i++) {
                    CategoryBean categoryBean = otherChannelItems.get(i);
                    categoryBean.setType(0);
                    categoryBean.setSort(otherChannelItems.size() - i);
                    MyApplication.getInstances().getDaoSession().getCategoryBeanDao().save(categoryBean);
                }
                mMyChannelItems= myChannelItems;
                mOtherItems= otherChannelItems;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb_channle:
                EventBus.getDefault().post(mMyChannelItems);
                finish();
                break;
                default:
        }
    }
}
