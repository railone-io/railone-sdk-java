package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class NewCardReq {

    //要充值的用户编号
    private String acct_no;

    //银行卡类型ID
    private String card_type_id;


//   机构端交易流水号
    private String cust_tx_id;


    public String getAcct_no() {
        return acct_no;
    }
    public void setAcct_no(String acct_no) {
        this.acct_no = acct_no;
    }

    public String getCard_type_id() {
        return card_type_id;
    }

    public void setCard_type_id(String card_type_id) {
        this.card_type_id = card_type_id == null ? null : card_type_id.trim();
    }

    public String getCust_tx_id() {
        return cust_tx_id;
    }


    public void setCust_tx_id(String cust_tx_id) {
        this.cust_tx_id = cust_tx_id;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
