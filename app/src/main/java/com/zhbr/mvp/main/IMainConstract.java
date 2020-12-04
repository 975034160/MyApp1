package com.zhbr.mvp.main;

import java.util.List;

public interface IMainConstract {

    interface M{
        void getLocalData();
        void getNetData();
    }

    interface VP{

        void reqeustData();

        void responseData(List<String> responseData);

    }

}
