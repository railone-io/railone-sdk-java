package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class CalcCryptoReq {

    private String currency_amount;

    private String card_type_id;

    private String coin_type;



    public String getCurrency_amount() {
        return currency_amount;
    }
    public void setCurrency_amount(String currency_amount) {
        this.currency_amount = currency_amount;
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
