package com.example.sunflower_java;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Time:2020/1/17 8:24
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
