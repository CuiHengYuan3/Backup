package com.example.lenovo.myapplication.util;

import android.app.Application;
import android.content.Context;

public class myApplication extends Application {
private  static Context context;
    @Override
    public void onCreate() {

        super.onCreate();
        context = getApplicationContext();
        }

    public static Context getContext() {
        return context;
    }
}
