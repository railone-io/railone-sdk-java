package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class CalcCurrencyReq {

    private String coin_amount;

    private String card_type_id;

    private String coin_type;



    public String getCoin_amount() {
        return coin_amount;
    }
    public void setCoin_amount(String coin_amount) {
        this.coin_amount = coin_amount;
    }

    public String getCard_type_id() {
        return card_type_id;
    }

    public void setCard_type_id(String card_type_id) {
        this.card_type_id = card_type_id == null ? null : card_type_id.trim();
    }

    public String getCoin_type() {
        return coin_type;
    }


    public void setCoin_type(String coin_type) {
        this.coin_type = coin_type;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
