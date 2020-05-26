package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class CardInfoReq {

    //卡号
    private String card_no;

    //publickey
    private String publickey;


    public String getCard_no() {
        return card_no;
    }
    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }
    public String getPublickey() {
        return publickey;
    }
    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }


    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
