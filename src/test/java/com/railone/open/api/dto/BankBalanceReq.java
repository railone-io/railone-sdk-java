package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class BankBalanceReq {

    private String card_no;

    public String getCard_no() {
        return card_no;
    }
    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
