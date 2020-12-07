package com.zhbr.mvp.main;

import android.annotation.SuppressLint;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.zhbr.R;
import com.zhbr.bean.Message;
import com.zhbr.mvp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainAtivity extends BaseActivity<MainPresenter,IMainConstract.VP> {

    TextView tv_title;



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
//                myDataSet.addAll(responseData);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter.notifyDataSetChanged();
//                    }
//                });
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

        //隐藏顶部的导航栏
//        this.getSupportActionBar().hide();
        tv_title= findViewById(R.id.tv_bar_title);
//        tv_title.setText("首页");
        tv_title.setGravity(Gravity.CENTER);

        //底部导航栏
        BottomNavigationView bnv = findViewById(R.id.bnv);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        AppBarConfiguration configuration =new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(bnv,navController);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
//        getConstract().reqeustData();
    }

    @Override
    public void destory() {

    }

    @Override
    public void onClick(View v) {

    }
}
