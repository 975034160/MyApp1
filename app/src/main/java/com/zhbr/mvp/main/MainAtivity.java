package com.zhbr.mvp.main;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;

import com.zhbr.R;
import com.zhbr.bean.Message;
import com.zhbr.mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAtivity extends BaseActivity<MainPresenter,IMainConstract.VP> {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Message> myDataSet=new ArrayList<>();

    @Override
    public IMainConstract.VP getConstract() {
        return new IMainConstract.VP() {
            @Override
            public void reqeustData() {
                mPresenter.getContract().reqeustData();
            }

            @Override
            public void responseData( final List<Message> responseData) {

                /**
                 * myDataSet=responseData 不能刷新数据，因为引用改变了。
                 */
                myDataSet.addAll(responseData);
                System.out.println(responseData.size());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
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

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(MainAtivity.this);
        recyclerView.setLayoutManager(layoutManager);
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
