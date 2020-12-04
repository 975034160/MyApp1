package com.zhbr.mvp.regist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhbr.R;
import com.zhbr.mvp.base.BaseActivity;


public class RegistActivity extends BaseActivity<RegistPresenter,IRegistContract.VP> {

    private Button btn_regist;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_pwd1;
    private EditText et_pwd2;


    @Override
    public IRegistContract.VP getConstract() {
        return new IRegistContract.VP() {
            @Override
            public void requestRegist(String name, String phone, String pwd1,String pwd2) {
                mPresenter.getContract().requestRegist(name,phone,pwd1,pwd2);
            }

            @Override
            public void responseResult(boolean result) {

            }
        };
    }

    @Override
    public RegistPresenter getPresenterInstance() {
        return new RegistPresenter();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_regist;
    }

    @Override
    public void initView() {
        btn_regist= findViewById(R.id.btn_regist);
        et_name=findViewById(R.id.et_name);
        et_phone=findViewById(R.id.et_phone);
        et_pwd1=findViewById(R.id.et_pwd1);
        et_pwd2=findViewById(R.id.et_pwd2);
    }

    @Override
    public void initListener() {
        btn_regist.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void destory() {
        mPresenter.unBindView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regist:
                getConstract().requestRegist(et_name.getText().toString(),et_phone.getText().toString(),et_pwd1.getText().toString(),et_pwd2.getText().toString());
                break;
        }
    }
}
