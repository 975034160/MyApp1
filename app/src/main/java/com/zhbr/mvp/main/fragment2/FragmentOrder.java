package com.zhbr.mvp.main.fragment2;

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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class FragmentOrder extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Message> myDataSet=new ArrayList<>();
    private ViewModelOrder mViewModel;

    private RadioButton rbt_95598;
    private RadioButton rbt_zdqx;
    private RadioButton rbt_xcx;
    private RadioButton rbt_hw;

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
        tv_bar_title.setText("工单");

        rbt_95598 = getView().findViewById(R.id.rbt_95598);
        rbt_zdqx  = getView().findViewById(R.id.rbt_zdqx);
        rbt_xcx   = getView().findViewById(R.id.rbt_xcx);
        rbt_hw    = getView().findViewById(R.id.rbt_hw);
        rbt_95598.setOnClickListener(this);
        rbt_zdqx.setOnClickListener(this);
        rbt_xcx.setOnClickListener(this);
        rbt_hw.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbt_95598:
                Toast.makeText(getContext(),"95598工单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbt_zdqx:
                Toast.makeText(getContext(),"主动抢修工单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbt_xcx:
                Toast.makeText(getContext(),"小程序工单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbt_hw:
                Toast.makeText(getContext(),"话务工单",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
