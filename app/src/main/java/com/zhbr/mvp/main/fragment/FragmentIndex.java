package com.zhbr.mvp.main.fragment;

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

import com.zhbr.R;
import com.zhbr.bean.Message;
import com.zhbr.mvp.main.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentIndex extends Fragment {

    private ViewModelIndex mViewModel;

    public static FragmentIndex newInstance() {
        return new FragmentIndex();
    }


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Message> myDataSet=new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModelIndex.class);
        // TODO: Use the ViewModel

        recyclerView = getView().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        myDataSet.add(new Message(1,"消息","helloworld","20201207120000"));
        myDataSet.add(new Message(2,"消息","helloworld","20201207120000"));
        myDataSet.add(new Message(3,"消息","helloworld","20201207120000"));
        myDataSet.add(new Message(4,"消息","helloworld","20201207120000"));

        adapter= new MyAdapter(myDataSet);
        recyclerView.setAdapter(adapter);

    }

}
