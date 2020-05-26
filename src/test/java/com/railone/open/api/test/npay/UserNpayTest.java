package com.railone.open.api.test.npay;

import com.railone.open.api.util.HmacSHA256Base64Util;
import okhttp3.*;
import org.junit.Test;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class UserNpayTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "061e2f174e834e3e9f9df9fd86410c64";
    private static final String apiSecret = "c50be11d-5e7d-4452-aaf8-f91dbf513f19";
    private static final String apiPassphrase = "11111111";


    public static final String SIGN_SEPARATOR = ":";



    @Test
    public void getUserTransaction() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "GET";
        String requestPath = "/api/v1/npay/transactions";
        String requestQueryStr = "acct_no=did:ont:AMyePQSNqfpYc8tf5mnV2Yu7rGgczZ1qmn&page_num=1&page_size=20";

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
    public void getUserAsset() throws Exception {
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String method = "GET";
        String requestPath = "/api/v1/npay/asset";
        String requestQueryStr = "acct_no=did:ont:AMyePQSNqfpYc8tf5mnV2Yu7rGgczZ1qmn";

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
}
