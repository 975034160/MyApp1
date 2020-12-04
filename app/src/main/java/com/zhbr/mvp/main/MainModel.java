package com.zhbr.mvp.main;

import com.zhbr.mvp.base.BaseModel;

public class MainModel extends BaseModel<MainPresenter,IMainConstract.M> {
    /**
     * P层实例化Model的时候将自己传给model
     *
     * @param presenter
     */
    public MainModel(MainPresenter presenter) {
        super(presenter);
    }

    @Override
    public IMainConstract.M getContract() {
        return new IMainConstract.M() {
            @Override
            public void getLocalData() {
                String[] data = new String[]{"mxl","ljx"};
                mPresenter.getContract().responseData(data);
            }

            @Override
            public void getNetData() {

            }
        };
    }
}
