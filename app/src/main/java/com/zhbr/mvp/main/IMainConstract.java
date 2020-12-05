package com.zhbr.mvp.main;

import com.zhbr.bean.Message;

import java.util.List;

public interface IMainConstract {

    interface M{
        void getLocalData();
        void getNetData();
    }

    interface VP{

        void reqeustData();

        void responseData(List<Message> responseData);

    }

}
