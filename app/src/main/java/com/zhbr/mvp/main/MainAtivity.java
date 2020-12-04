package com.zhbr.mvp.main;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;

import com.zhbr.R;
import com.zhbr.mvp.base.BaseActivity;

public class MainAtivity extends BaseActivity<MainPresenter,IMainConstract.VP> {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private String[] myDataSet=new String[]{};

    @Override
    public IMainConstract.VP getConstract() {
        return new IMainConstract.VP() {
            @Override
            public void reqeustData() {
                mPresenter.getContract().reqeustData();
            }

            @Override
            public void responseData(String[] responseData) {
                myDataSet=responseData;
            }
        };
    }

    @Override
    public MainPresenter getPresenterInstance() {
        return new MainPresenter();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @SuppressLint("ResourceType")
    @Override
    public void initView() {
        recyclerView=findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter= new MyAdapter(myDataSet);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getConstract().reqeustData();
    }

    @Override
    public void destory() {

    }

    @Override
    public void onClick(View v) {

    }
}
