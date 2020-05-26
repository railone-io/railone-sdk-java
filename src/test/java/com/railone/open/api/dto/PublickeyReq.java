package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class PublickeyReq {


    private String public_key;


    public String getPublic_key() {
        return public_key;
    }
    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
