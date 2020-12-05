package com.zhbr.mvp.main;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.zhbr.bean.Message;
import com.zhbr.commons.HttpUtils;
import com.zhbr.commons.ResponseData;
import com.zhbr.mvp.base.BaseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
                List<Message> data = new ArrayList<>();
                data.add(new Message(1,"新消息","您的好友孟祥龙邀请你吃饭！","2020-12-06 12:42:11"));
                mPresenter.getContract().responseData(data);
            }

            @Override
            public void getNetData() {

                HttpUtils.getHttpUtils().doGet("http://121.4.54.38/message/getMessage", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("网络请求：", "onFailure: 网络请求失败！ ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        List list= new ArrayList<>();
                        List messages= new ArrayList<>();
                        ResponseData<List<String>> responseData = new Gson().fromJson(response.body().string(),ResponseData.class);
                        Map<String,List<String>> map = responseData.getData();
                        list = map.get("messages");
                        for(int i=0;i<list.size();i++){
                            messages.add(new Gson().fromJson(list.get(i).toString().replace(":","").replace(" ",""),Message.class));
                        }
                        mPresenter.getContract().responseData(messages);
                    }
                });

            }
        };
    }
}
