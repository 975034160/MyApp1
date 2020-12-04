package com.zhbr.mvp.regist;

public interface IRegistContract {


    interface M{
        void requestRegist(String name,String phone,String pwd1,String pwd2);
    }


    interface VP{

        void requestRegist(String name,String phone,String pwd1,String pwd2);

        void responseResult(boolean result);

    }


}
