package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;


public class AttachmentReq {


    @JSONField(name = "card_no")
    private String card_no;


    @JSONField(name = "poa_doc")
    private String poa_doc;


    @JSONField(name = "active_doc")
    private String active_doc;


    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no == null ? null : card_no.trim();
    }

    public String getPoa_doc() {
        return poa_doc;
    }

    public void setPoa_doc(String poa_doc) {
        this.poa_doc = poa_doc == null ? null : poa_doc.trim();
    }

    public String getActive_doc() {
        return active_doc;
    }

    public void setActive_doc(String active_doc) {
        this.active_doc = active_doc == null ? null : active_doc.trim();
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }


}