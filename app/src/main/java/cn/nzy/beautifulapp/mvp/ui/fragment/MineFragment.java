package cn.nzy.beautifulapp.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.nzy.beautifulapp.R;

/**
 * on 2018/5/21. created by nzy
 */

public class MineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup inflate = (ViewGroup) View.inflate(getActivity(), R.layout.fragment_living, null);
        TextView textView = new TextView(getActivity());
        textView.setTextSize(200);
        textView.setText(this.getClass().getSimpleName());
        inflate.addView(textView);
        return inflate;
    }
}
