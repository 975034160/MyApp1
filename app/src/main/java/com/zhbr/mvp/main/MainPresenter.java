package com.zhbr.mvp.main;

import com.zhbr.bean.Message;
import com.zhbr.mvp.base.BasePresenter;

import java.util.List;

public class MainPresenter extends BasePresenter<MainModel,MainAtivity,IMainConstract.VP> {
    @Override
    public MainModel getModelInstance() {
        return new MainModel(this);
    }

    @Override
    public IMainConstract.VP getContract() {
        return new IMainConstract.VP() {
            @Override
            public void reqeustData() {
                mModel.getContract().getNetData();
            }

            @Override
            public void responseData(List<Message> responseData) {
                mView.getConstract().responseData(responseData);
            }
        };
    }
}
