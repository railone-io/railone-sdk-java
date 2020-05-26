package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class ActiveCardReq {

    //要充值的用户编号
    private String acct_no;

    //卡号
    private String card_no;



    public String getAcct_no() {
        return acct_no;
    }
    public void setAcct_no(String acct_no) {
        this.acct_no = acct_no;
    }

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
