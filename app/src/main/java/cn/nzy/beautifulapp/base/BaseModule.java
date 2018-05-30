package cn.nzy.beautifulapp.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class BaseModule implements BaseContract.IBaseModule {

    public BaseModule(Fragment loginAct) {
    }
    public BaseModule(AppCompatActivity loginAct) {
    }
}