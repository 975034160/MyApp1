package com.zhbr.mvp.login;

/**
 *  Login契约类
 *  定义 login的各个层需要有哪些方法
 */

public interface ILoginConsract {


    interface M {
        void requestLogin(String name,String pwd);
    }

    //V层和P层共有的方法
    interface VP {

        void requestLogin(String name,String pwd);

        void responseLoginRequst(boolean loginStatusResult);

    }

}
