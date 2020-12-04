package com.zhbr.mvp.base;

/**
 *  Presenter的基类
 *
 *  负责M和V层的交互
 *  需要拿到M和V层的实例 使用泛型定义
 *
 */

public abstract class BasePresenter<M extends BaseModel,V extends BaseActivity,CONSTRACT> extends SuperBase<CONSTRACT> {

    //定义model和view的实例，用于操作它们之间的交互
    public M mModel;
    public V mView;


    public BasePresenter(){
        this.mModel=getModelInstance();
    }


    /**
     * 传入Activity的实例
     * @param view
     */
    public void bindView(V view){
        this.mView= view;
    }

    /**
     * 当activity销毁的时候需要在P层解除绑定
     */
    public void unBindView(){
        this.mView=null;
    }



    /**
     * 由子类实现此方法， 将model的实例传给P层
     * 在父类的构造方法中调用此方法绑定。
     * 子类实例化model的时候将自己传个model 用于model的P层绑定。
     */
    public abstract M getModelInstance();


}
