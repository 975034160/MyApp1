package com.zhbr.mvp.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhbr.R;
import com.zhbr.mvp.base.BaseActivity;
import com.zhbr.mvp.regist.RegistActivity;

public class LoginActivity extends BaseActivity<LoginPresenter ,ILoginConsract.VP>{



    private EditText etName;
    private EditText etPwd;
    private Button btn_login;
    private Button btn_reg;

    @Override
    public ILoginConsract.VP getConstract(){
        return new ILoginConsract.VP() {
            @Override
            public void requestLogin(String name, String pwd) {
                mPresenter.getContract().requestLogin(name,pwd);
            }

            @Override
            public void responseLoginRequst(boolean loginStatusResult) {
                if(loginStatusResult){
                    Toast.makeText(getApplicationContext(),"登录成功！！",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"登录失败！！",Toast.LENGTH_LONG).show();

                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenterInstance() {
        return new LoginPresenter();
    }


    @Override
    public int getContentViewId() {
        //获取layout的id
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etName=findViewById(R.id.etName);
        etPwd= findViewById(R.id.etPwd);

        btn_login = findViewById(R.id.btn_login);
        btn_reg = findViewById(R.id.btn_reg);
    }

    @Override
    public void initListener() {
        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void destory() {
        //当前页面销毁的时候解除和P层的绑定
        mPresenter.unBindView();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                getConstract().requestLogin(etName.getText().toString(),etPwd.getText().toString());
                break;
            case R.id.btn_reg:
                Toast.makeText(getApplicationContext(),"点击注册按钮！",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
                break;
        }
    }



}
