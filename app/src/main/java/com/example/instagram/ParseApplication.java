package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(String.valueOf(R.string.app_id))
                .clientKey(String.valueOf(R.string.client_key))
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
