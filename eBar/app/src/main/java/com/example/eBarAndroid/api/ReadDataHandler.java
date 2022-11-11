package com.example.eBarAndroid.api;

import android.os.Handler;

import org.json.JSONObject;

public class ReadDataHandler extends Handler {
    private String json;
    private JSONObject jsonObject;

    public String getJson(){
        return json;
    }

    public void setJson(String json){
        this.json = json;
    }

}
