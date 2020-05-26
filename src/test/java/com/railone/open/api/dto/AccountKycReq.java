package com.railone.open.api.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;


public class AccountKycReq {


    /**
     * 机构端用户编号(机构端唯一)
     */
    @JSONField(name = "acct_no")
    private String acctNo;

    /**
     * 机构端用户名
     */
    @JSONField(name = "acct_name")
    private String acctName;

    /**
     * 真实用户姓
     */
    @JSONField(name = "first_name")
    private String firstName;

    /**
     * 真实用户姓
     */
    @JSONField(name = "last_name")
    private String lastName;

    /**
     * 1男,2女,3未知
     */
    @JSONField(name = "gender")
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String state;

    /**
     * 现居地
     */
    private String country;

    /**
     * 国家号
     */
    @JSONField(name = "country_code")
    private String countryCode;

    /**
     * 证件号码
     */
    @JSONField(name = "doc_no")
    private String docNo;

    /**
     * 证件类型:1=护照,2=身份证
     */
    @JSONField(name = "doc_type")
    private String docType;

    /**
     * 正面照
     */
    @JSONField(name = "front_doc")
    private String frontDoc;

    /**
     * 反面照
     */
    @JSONField(name = "back_doc")
    private String backDoc;

    /**
     * 手持照
     */
    @JSONField(name = "mix_doc")
    private String mixDoc;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 通讯地址
     */
    private String address;

    /**
     * 用户认证状态：0 已提交, 1 认证通过(开卡成功), 2 认证未通过
     */
    private Integer status;


    /**
     * 出生国
     */
    private String nationality;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 妈妈的名字
     */
    @JSONField(name = "maiden_name")
    private String maidenName;

    /**
     * 银行卡类型id
     */
    @JSONField(name = "card_type_id")
    private String cardTypeId;

    /**
     * kyc 其他信息
     */
    private String kycInfo;

    private String poa_doc;

    /**
     * 邮箱验证码
     */
    private String mailVerificationCode;

    /**
     * 邮箱token
     */
    private String mailToken;



    /**
     * 获取机构端用户编号(机构端唯一)
     *
     * @return acct_no - 机构端用户编号(机构端唯一)
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * 设置机构端用户编号(机构端唯一)
     *
     * @param acctNo 机构端用户编号(机构端唯一)
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    /**
     * 获取机构端用户名
     *
     * @return acct_name - 机构端用户名
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * 设置机构端用户名
     *
     * @param acctName 机构端用户名
     */
    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    /**
     * 获取真实用户名
     *
     * @return first_name - 真实用户名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置真实用户名
     *
     * @param firstName 真实用户名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * 获取真实用户姓
     *
     * @return last_name - 真实用户姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置真实用户姓
     *
     * @param lastName 真实用户姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * 获取1男,2女,3未知
     *
     * @return sex - 1男,2女,3未知
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置1男,2女,3未知
     *
     * @param gender 1男,2女,3未知
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取省份
     *
     * @return state - 省份
     */
    public String getState() {
        return state;
    }

    /**
     * 设置省份
     *
     * @param state 省份
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取现居地
     *
     * @return country - 现居地
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置现居地
     *
     * @param country 现居地
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取手机国际区号
     *
     * @return country_code - 手机国际区号
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 设置国家号
     *
     * @param countryCode 国家号
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * 获取证件号码
     *
     * @return doc_no - 证件号码
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * 设置证件号码
     *
     * @param docNo 证件号码
     */
    public void setDocNo(String docNo) {
        this.docNo = docNo == null ? null : docNo.trim();
    }

    /**
     * 获取证件类型:1=护照,2=身份证
     *
     * @return doc_type - 证件类型:1=护照,2=身份证
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 设置证件类型:1=护照,2=身份证
     *
     * @param docType 证件类型:1=护照,2=身份证
     */
    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    /**
     * 获取正面照
     *
     * @return front_doc - 正面照
     */
    public String getFrontDoc() {
        return frontDoc;
    }

    /**
     * 设置正面照
     *
     * @param frontDoc 正面照
     */
    public void setFrontDoc(String frontDoc) {
        this.frontDoc = frontDoc == null ? null : frontDoc.trim();
    }

    /**
     * 获取反面照
     *
     * @return back_doc - 反面照
     */
    public String getBackDoc() {
        return backDoc;
    }

    /**
     * 设置反面照
     *
     * @param backDoc 反面照
     */
    public void setBackDoc(String backDoc) {
        this.backDoc = backDoc == null ? null : backDoc.trim();
    }

    /**
     * 获取手持照
     *
     * @return mix_doc - 手持照
     */
    public String getMixDoc() {
        return mixDoc;
    }

    /**
     * 设置手持照
     *
     * @param mixDoc 手持照
     */
    public void setMixDoc(String mixDoc) {
        this.mixDoc = mixDoc == null ? null : mixDoc.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 获取通讯地址
     *
     * @return address - 通讯地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置通讯地址
     *
     * @param address 通讯地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取用户认证状态：0 已提交, 1 认证通过(开卡成功), 2 认证未通过
     *
     * @return status - 用户认证状态：0 已提交, 1 认证通过(开卡成功), 2 认证未通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户认证状态：0 已提交, 1 认证通过(开卡成功), 2 认证未通过
     *
     * @param status 用户认证状态：0 已提交, 1 认证通过(开卡成功), 2 认证未通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取出生国
     *
     * @return nationality - 出生国
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置出生国
     *
     * @param nationality 出生国
     */
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    /**
     * 获取邮编
     *
     * @return zipcode - 邮编
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置邮编
     *
     * @param zipcode 邮编
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * 获取妈妈的名字
     *
     * @return maiden_name - 妈妈的名字
     */
    public String getMaidenName() {
        return maidenName;
    }

    /**
     * 设置妈妈的名字
     *
     * @param maidenName 妈妈的名字
     */
    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName == null ? null : maidenName.trim();
    }

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId == null ? null : cardTypeId.trim();
    }

    /**
     * 获取kyc 其他信息
     *
     * @return kyc_info - kyc 其他信息
     */
    public String getKycInfo() {
        return kycInfo;
    }

    /**
     * 设置kyc 其他信息
     *
     * @param kycInfo kyc 其他信息
     */
    public void setKycInfo(String kycInfo) {
        this.kycInfo = kycInfo == null ? null : kycInfo.trim();
    }


    public String getPoa_doc() {
        return poa_doc;
    }
    public void setPoa_doc(String poa_doc) {
        this.poa_doc = poa_doc == null ? null : poa_doc.trim();
    }

    public String getMailVerificationCode() {
        return mailVerificationCode;
    }
    public void setMailVerificationCode(String mailVerificationCode) {
        this.mailVerificationCode = mailVerificationCode == null ? null : mailVerificationCode.trim();
    }

    public String getMailToken() {
        return mailToken;
    }
    public void setMailToken(String mailToken) {
        this.mailToken = mailToken == null ? null : mailToken.trim();
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }


}