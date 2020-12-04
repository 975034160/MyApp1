package com.zhbr.mvp.login;

import android.util.Log;
import android.widget.Toast;

import com.zhbr.commons.HttpUtils;
import com.zhbr.mvp.base.BaseModel;
import com.zhbr.mvp.base.BasePresenter;
import com.zhbr.mvp.regist.RegistActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginModel extends BaseModel<LoginPresenter,ILoginConsract.M>{
    /**
     * P层实例化Model的时候将自己传给model
     *å
     * @param presenter
     */
    public LoginModel(LoginPresenter presenter) {
        super(presenter);
    }


//    @Override
//    public void requestLogin(String name, String pwd) {
//        Log.d("LoginModel ","用户名："+name+"  密码："+pwd);
//
//        if(name.equals("admin")&&pwd.equals("123456")){
//            mPresenter.responseLoginRequst(true);
//        }else {
//            mPresenter.responseLoginRequst(false);
//        }
//
//    }

    @Override
    public ILoginConsract.M getContract() {
        return new ILoginConsract.M() {
            @Override
            public void requestLogin(String name, String pwd) {
                Log.d("LoginModel ","用户名："+name+"  密码："+pwd);

                Map map = new HashMap<String,String>();
                map.put("username",name);
                map.put("password",pwd);

                HttpUtils.getHttpUtils().doPost("http://121.4.54.38/user/login", map, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("网络请求提示","网络请求失败！");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("网络请求提示","网络请求成功！");
                        Log.i("网络请求返回信息：",response.body().string());
                    }
                });
            }
        };
    }
}
