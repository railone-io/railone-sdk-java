package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;

public class DepositFiatAmountReq {

    //要充值的用户编号
    private String acct_no;

    //卡号
    private String card_no;

    //金额
    private String credited_amount;

    //coin 类型
    private String coin_type;


    // 机构端交易流水号
    private String cust_tx_id;

    //备注
    private String remark;


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
    public String getCredited_amount() {
        return credited_amount;
    }
    public void setCredited_amount(String credited_amount) {
        this.credited_amount = credited_amount;
    }

    public String getCoin_type() {
        return coin_type;
    }
    public void setCoin_type(String coin_type) {
        this.coin_type = coin_type;
    }

    public String getCust_tx_id() {
        return cust_tx_id;
    }

    public void setCust_tx_id(String cust_tx_id) {
        this.cust_tx_id = cust_tx_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
