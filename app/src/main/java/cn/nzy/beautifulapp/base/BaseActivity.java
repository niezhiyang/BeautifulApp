package cn.nzy.beautifulapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity<V extends BaseContract.IBaseView,P extends BasePresenter> extends AppCompatActivity implements BaseContract.IBaseView {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            presenter= setPresenter();
            presenter.attatchWindow(setModule());
    }

    public P presenter;
    protected abstract P setPresenter();

    protected abstract BaseModule setModule();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachWindow();
    }
}
