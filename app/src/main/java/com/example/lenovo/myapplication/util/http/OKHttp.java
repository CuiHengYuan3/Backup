package com.example.lenovo.myapplication.util.http;

import javax.security.auth.callback.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OKHttp {
public  static  void sendOKHttpcRequest(String adress, okhttp3.Callback callback){//Callback到底是哪个？
    OkHttpClient client=new OkHttpClient();
    Request request=new Request.Builder().url(adress).build();//?/？？？?到底是哪个包？？？
client.newCall(request).enqueue( callback);
}

}
