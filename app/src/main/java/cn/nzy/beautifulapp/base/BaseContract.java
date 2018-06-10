package cn.nzy.beautifulapp.base;

public class BaseContract {
    public interface IBaseModule {
    }

    public interface IBasePresenter  {
    }

    public interface IBaseView {
        void showNetError(Throwable throwable);
    }
}