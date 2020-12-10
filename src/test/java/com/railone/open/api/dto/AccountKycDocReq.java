package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class AccountKycDocReq {

    //要充值的用户编号
    private String acct_no;

    /**
     * 银行卡类型id
     */
    @JSONField(name = "card_type_id")
    private String cardTypeId;

    //卡号
    private String[] docs;



    public String getAcct_no() {
        return acct_no;
    }
    public void setAcct_no(String acct_no) {
        this.acct_no = acct_no;
    }

    public String getCardTypeId() {
        return cardTypeId;
    }
    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId == null ? null : cardTypeId.trim();
    }

    public String[] getDocs() {
        return docs;
    }
    public void setDocs(String[] docs) {
        this.docs = docs;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
