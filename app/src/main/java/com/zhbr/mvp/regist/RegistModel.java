package com.zhbr.mvp.regist;

import android.util.Log;

import com.zhbr.mvp.base.BaseModel;

public class RegistModel extends BaseModel<RegistPresenter,IRegistContract.M> {
    /**
     * P层实例化Model的时候将自己传给model
     *
     * @param presenter
     */
    public RegistModel(RegistPresenter presenter) {
        super(presenter);
    }

    @Override
    public IRegistContract.M getContract() {
        return new IRegistContract.M() {
            @Override
            public void requestRegist(String name, String phone, String pwd1, String pwd2) {
                Log.d("注册参数：","name:"+name+" phone:"+phone+" pwd1:"+pwd1+" pwd2:"+pwd2);
            }
        };
    }
}
