package com.zhbr.mvp.main.fragment;

import android.animation.ObjectAnimator;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhbr.R;
import com.zhbr.bean.Message;
import com.zhbr.commons.HttpUtils;
import com.zhbr.commons.ResponseData;
import com.zhbr.mvp.main.MyAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FragmentOrder extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Message> myDataSet=new ArrayList<>();

    private ViewModelOrder mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModelOrder.class);
        // TODO: Use the ViewModel

        //获取activity中的TextView组件
        TextView tv_bar_title = getActivity().findViewById(R.id.tv_bar_title);

        //获取Fregment中的TextView组件
        //TextView tv_bar_title = getView.findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("工单");





        recyclerView = getView().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


//        myDataSet.add(new Message(1,"消息","helloworld","20201207120000"));
//        myDataSet.add(new Message(2,"消息","helloworld","20201207120000"));
//        myDataSet.add(new Message(3,"消息","helloworld","20201207120000"));
//        myDataSet.add(new Message(4,"消息","helloworld","20201207120000"));

        HttpUtils.getHttpUtils().doGet("http://121.4.54.38/message/getMessage", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                List list= new ArrayList<>();
                List messages= new ArrayList<>();
                ResponseData<List<String>> responseData = new Gson().fromJson(response.body().string(),ResponseData.class);
                Map<String,List<String>> map = responseData.getData();
                list = map.get("messages");
                for(int i=0;i<list.size();i++){
                    messages.add(new Gson().fromJson(list.get(i).toString().replace(":","").replace(" ",""),Message.class));
                }
                myDataSet.addAll(messages);
                //在子线程中刷新ui
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });

            }
        });

        adapter= new MyAdapter(myDataSet);
        recyclerView.setAdapter(adapter);
    }

}
