package com.zhbr.mvp.main;

import com.zhbr.mvp.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

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
                List<String> data = new ArrayList<>();
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("李朋朋");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                data.add("杨亚亚");
                mPresenter.getContract().responseData(data);
            }

            @Override
            public void getNetData() {

            }
        };
    }
}
