package com.zhbr.mvp.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhbr.R;

public class FragmentMy extends Fragment {

    private ViewModelMy mViewModel;

    public static FragmentMy newInstance() {
        return new FragmentMy();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModelMy.class);
        // TODO: Use the ViewModel

        //获取activity中的TextView组件
        TextView tv_bar_title = getActivity().findViewById(R.id.tv_bar_title);

        //获取Fregment中的TextView组件
        //TextView tv_bar_title = getView.findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("我的");

    }

}
