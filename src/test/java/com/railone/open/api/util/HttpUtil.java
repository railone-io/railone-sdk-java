package com.railone.open.api.util;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.util.TreeMap;

/**
 * @Description:
 * @date 2020/3/27
 */
public class HttpUtil {

    private static  String host = "";
    private static  String apiKey = "";
    private static  String apiSecret = "";
    private static  String apiPassphrase = "";


    public static void init(String apihost,String apikey,String apisecret,String apipassphrase){
        host = apihost;
        apiKey = apikey;
        apiSecret = apisecret;
        apiPassphrase = apipassphrase;
    }
    public static void  get(String requestPath,String requestQueryStr) throws Exception{
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        String SIGN_SEPARATOR = ":";
        String method = "GET";
        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, null);

        String authorizationStr = "Railone"
                + SIGN_SEPARATOR
                + apiKey
                +SIGN_SEPARATOR
                + timeStampStr
                +SIGN_SEPARATOR
                + sign;
        System.out.println(host+requestPath);
        System.out.println("Request Url:"+ host+requestPath+"?"+requestQueryStr );
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(host + requestPath + "?" + requestQueryStr)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authorizationStr)
                .addHeader("Access-Passphrase", apiPassphrase)
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
    public static void  post(String requestPath,String requestQueryStr,String reqString) throws Exception{
        String SIGN_SEPARATOR = ":";
        String method = "POST";
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        TreeMap<String,String> map = JSONObject.parseObject(reqString,TreeMap.class);

        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, map);

        String authorizationStr = "Railone"
                + SIGN_SEPARATOR
                + apiKey
                +SIGN_SEPARATOR
                + timeStampStr
                +SIGN_SEPARATOR
                + sign;
        System.out.println(host+requestPath);
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, reqString);
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

    public static void  put(String requestPath,String requestQueryStr,String reqString) throws Exception{
        String SIGN_SEPARATOR = ":";
        String method = "PUT";
        String timeStampStr = String.valueOf(System.currentTimeMillis());
        TreeMap<String,String> map = JSONObject.parseObject(reqString,TreeMap.class);

        String sign = HmacSHA256Base64Util.sign(timeStampStr, method, requestPath,  requestQueryStr, apiKey, apiSecret, map);

        String authorizationStr = "Railone"
                + SIGN_SEPARATOR
                + apiKey
                +SIGN_SEPARATOR
                + timeStampStr
                +SIGN_SEPARATOR
                + sign;
        System.out.println(host+requestPath);
        System.out.println("Authorization:"+authorizationStr);
        System.out.println("Access-Passphrase:"+apiPassphrase);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, reqString);
        Request request = new Request.Builder()
                .url(host+requestPath)
                .put(body)
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
