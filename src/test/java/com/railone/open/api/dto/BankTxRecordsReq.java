package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class BankTxRecordsReq {

    private String card_no;

    private String former_month_year;

    private String latter_month_year;

    public String getCard_no() {
        return card_no;
    }
    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getFormer_month_year() {
        return former_month_year;
    }
    public void setFormer_month_year(String former_month_year) {
        this.former_month_year = former_month_year;
    }

    public String getLatter_month_year() {
        return latter_month_year;
    }
    public void setLatter_month_year(String latter_month_year) {
        this.latter_month_year = latter_month_year;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
