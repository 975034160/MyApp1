package com.zhbr.mvp.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhbr.R;
import com.zhbr.bean.Message;
import com.zhbr.commons.HttpUtils;
import com.zhbr.commons.ResponseData;
import com.zhbr.mvp.main.IMainConstract;
import com.zhbr.mvp.main.MyAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FragmentIndex extends Fragment {

    private ViewModelIndex mViewModel;

    public static FragmentIndex newInstance() {
        return new FragmentIndex();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取Fregment中的TextView组件
        //TextView tv_bar_title = getView.findViewById(R.id.tv_bar_title);
        //获取activity中的TextView组件
        TextView tv_bar_title = getActivity().findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("首页");

        mViewModel = ViewModelProviders.of(this).get(ViewModelIndex.class);
        // TODO: Use the ViewModel



    }

}
