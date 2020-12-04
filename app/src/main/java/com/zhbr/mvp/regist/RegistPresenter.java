package com.zhbr.mvp.regist;

import com.zhbr.mvp.base.BaseModel;
import com.zhbr.mvp.base.BasePresenter;

public class RegistPresenter extends BasePresenter<RegistModel,RegistActivity,IRegistContract.VP> {
    @Override
    public RegistModel getModelInstance() {
        return new RegistModel(this);
    }

    @Override
    public IRegistContract.VP getContract() {
        return new IRegistContract.VP() {
            @Override
            public void requestRegist(String name, String phone, String pwd1,String pwd2) {
                mModel.getContract().requestRegist(name, phone, pwd1, pwd2);
            }

            @Override
            public void responseResult(boolean result) {

            }
        };
    }
}
