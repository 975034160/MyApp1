package com.zhbr.mvp.base;

/**
 *  model层的基类
 *  负责数据的请求、获取和处理；拿到数据后交给p层处理
 * @param <P>
 */


public abstract class BaseModel<P extends BasePresenter,CONSTRACT> extends SuperBase<CONSTRACT> {

    /**
     * model 通过网络或者文件获取数据后 需要将数据传给P层
     *
     * 拿到P层的实例  类型不确定 所以使用泛型  该泛型集成presenter的基类
     *
     */
    public P mPresenter;



    /**
     * P层实例化Model的时候将自己传给model
     */
    public BaseModel(P presenter){
        this.mPresenter=presenter;
    }



}
