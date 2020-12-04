package com.zhbr.mvp.main;

public interface IMainConstract {

    interface M{
        void getLocalData();
        void getNetData();
    }

    interface VP{

        void reqeustData();

        void responseData(String[] responseData);

    }

}
