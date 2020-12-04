package com.zhbr.commons;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final OkHttpClient okHttpClient;


    public HttpUtils() {

        //创建拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(6_000, TimeUnit.MILLISECONDS)
                .readTimeout(20_000, TimeUnit.MILLISECONDS)
                .writeTimeout(20_000, TimeUnit.MILLISECONDS)
                .addInterceptor(logging) //添加日志拦截器  也可以添加自定义拦截器
                .build();

    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }

    /**
     * 登录的post请求
     */
    public void doPost(String str, Map<String, String> map, Callback callback) {

        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().post(formBody).url(str).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 注册的网络请求Get
     */
    public void doGet(String str, Callback callback) {
        Request request = new Request.Builder()
//                .header("Accept","image/webp")    //添加header头信息  比如获取到了登录的token 可以在这里加入
//                .addHeader("Charset","UTF-8")
                .url(str).build();
        okHttpClient.newCall(request).enqueue(callback);
    }


}
