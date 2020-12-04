package com.zhbr.mvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 *  Activity基类
 *  实现基本的方法  供子类使用
 *
 */

public abstract class BaseActivity<P extends BasePresenter,CONSTRACT> extends AppCompatActivity   implements View.OnClickListener{

    public abstract CONSTRACT getConstract();


    // View层需要和P层交互  交给子类去实例化具体的p层
    public P mPresenter;


    /**
     * 重写onCreate方法
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定布局文件
        setContentView(getContentViewId());

        mPresenter = getPresenterInstance();
        mPresenter.bindView(this);

        //初始化页面
        initView();

        //初始化监听
        initListener();

        //初始化数据
        initData();

        // 可以在此添加很多方法  根据业务添加





    }

    //子类必须实现此方法 并传入P层的实例
    public abstract P getPresenterInstance();

    /**
     * 获取布局文件layout的ID 交给onCreate()方法初始化页面
     * @return layout的id
     */
    public abstract int getContentViewId();


    /**
     *  初始化页面
     */
    public abstract void initView();


    /**
     *  初始化监听
     *
     */
    public abstract void initListener();

    /**
     *  初始化数据
     *
     */
    public abstract void initData();

    //父类的销毁方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destory();
    }

    /**
     *  子类实现这个销毁方法， 在父类的销毁方法中调用
     */
    public abstract void destory();




}
