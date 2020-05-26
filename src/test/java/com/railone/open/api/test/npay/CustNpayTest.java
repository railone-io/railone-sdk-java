package com.railone.open.api.test.npay;

import com.alibaba.fastjson.JSONObject;
import com.railone.open.api.dto.NPayDepositReq;
import com.railone.open.api.enums.CoinTypeEnum;
import com.railone.open.api.util.HmacSHA256Base64Util;
import okhttp3.*;
import org.junit.Test;

import java.util.TreeMap;
import java.util.UUID;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class CustNpayTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "061e2f174e834e3e9f9df9fd86410c64";
    private static final String apiSecret = "c50be11d-5e7d-4452-aaf8-f91dbf513f19";
    private static final String apiPassphrase = "11111111";


    public static final String SIGN_SEPARATOR = ":";



    @Test
    public void getNpayTxTest() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "GET";
        String requestPath = "/api/v1/npay/cust/transaction";
        String requestQueryStr = "page_num=1&page_size=20";

        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, null);

        String authorizationStr = "Railone"
                + SIGN_SEPARATOR
                + apiKey
                +SIGN_SEPARATOR
                + timeStampStr
                +SIGN_SEPARATOR
                + sign;
        System.out.println();
        System.out.println("Request Url:"+ host+requestPath+"?"+requestQueryStr );
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(host+requestPath+"?"+requestQueryStr)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization",authorizationStr)
                .addHeader("Access-Passphrase",apiPassphrase)
                .build();
        Response response = client.newCall(request).execute();
        //System.out.println("result="+response.isSuccessful());
        System.out.println();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }else{
            System.out.println("error... " + response.body().string());
        }
    }

    @Test
    public void postDepositTest() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "POST";
        String requestPath = "/api/v1/npay/cust/transaction";
        String requestQueryStr = "";

        NPayDepositReq req = new NPayDepositReq();

        req.setAcct_no("did:ont:ALaRqCkXSWaHMDc5sLEEMVMWqCNDFi5eRZ");
        req.setCust_user_no("mw123");
        req.setCust_tx_id(UUID.randomUUID().toString());
        req.setCoin_type(CoinTypeEnum.PAX.value());
        req.setTx_amount("10");
        req.setBonus_coin_type(CoinTypeEnum.ONT.value());
        req.setBonus_tx_amount("1");
        req.setRemark("test deposit");

        TreeMap<String,String> map = JSONObject.parseObject(req.toString(),TreeMap.class);

        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, map);

        String authorizationStr = "Railone"
                + SIGN_SEPARATOR
                + apiKey
                +SIGN_SEPARATOR
                + timeStampStr
                +SIGN_SEPARATOR
                + sign;
        System.out.println();
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, JSONObject.toJSONString(req));
        Request request = new Request.Builder()
                .url(host+requestPath)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization",authorizationStr)
                .addHeader("Access-Passphrase",apiPassphrase)
                .build();
        Response response = client.newCall(request).execute();
        //System.out.println("result="+response.isSuccessful());
        System.out.println();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }else{
            System.out.println("error... " + response.body().string());
        }
    }
}
