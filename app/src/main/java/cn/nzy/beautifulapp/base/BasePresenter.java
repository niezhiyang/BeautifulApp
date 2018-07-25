package cn.nzy.beautifulapp.base;


public class BasePresenter<M extends BaseModule, V extends BaseContract.IBaseView> {
    public M module;

    public V view;

    public BasePresenter(V fragment) {
        view=fragment;
    }


    void attatchWindow(M m) {
        this.module = m;
    }

    void detachWindow() {
        this.module = null;
        this.view = null;
    }

}
