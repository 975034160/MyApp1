package com.zhbr.mvp.login;

import com.zhbr.commons.ResponseData;
import com.zhbr.mvp.base.BaseActivity;
import com.zhbr.mvp.base.BaseModel;
import com.zhbr.mvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginModel,LoginActivity,ILoginConsract.VP>{


    @Override
    public LoginModel getModelInstance() {
        return new LoginModel(this);
    }


//    @Override
//    public void requestLogin(String name, String pwd) {
//        mModel.getContract().requestLogin(name,pwd);
//    }
//
//    @Override
//    public void responseLoginRequst(boolean loginStatusResult) {
//        mView.responseLoginRequst(loginStatusResult);
//    }

    //实现契约接口定义的方法
    @Override
    public ILoginConsract.VP getContract() {
        return new ILoginConsract.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mModel.getContract().requestLogin(name,pwd);
            }

            @Override
            public void responseLoginRequst(ResponseData responseData) {
                mView.getConstract().responseLoginRequst(responseData);
            }
        };
    }
}
