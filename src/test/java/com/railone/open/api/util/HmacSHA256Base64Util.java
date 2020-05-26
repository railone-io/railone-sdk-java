package com.railone.open.api.util;


import com.railone.open.api.enums.CharsetEnum;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Set;
import java.util.TreeMap;

public class HmacSHA256Base64Util {


    public static String sign(String timestamp, String method, String requestPath,
                              String queryString, String appKey, String secretKey, TreeMap<String, String> body)  throws Exception {
        if (StringUtils.isEmpty(secretKey) || StringUtils.isEmpty(method)) {
            throw new Exception("secretKey error");
        }
        String preHash = preHash(timestamp, method, requestPath, queryString, appKey, body);
        System.out.println("origin sign data:{}"+preHash);
        byte[] secretKeyBytes = secretKey.getBytes(CharsetEnum.UTF_8.charset());
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes,"HmacSHA256");
        Mac mac = (Mac) MAC.clone();
        mac.init(secretKeySpec);
        return Base64.getEncoder().encodeToString(mac.doFinal(preHash.getBytes(CharsetEnum.UTF_8.charset())));
    }


    public static String preHash(String timestamp, String method, String requestPath, String queryString, String appKey, TreeMap<String, String> body) throws UnsupportedEncodingException {
        StringBuilder preHash = new StringBuilder();
        preHash.append(timestamp);
        preHash.append(method.toUpperCase());
        preHash.append(appKey);
        preHash.append(requestPath);
        if (!StringUtils.isEmpty(queryString)) {
            preHash.append("?").append(URLDecoder.decode(queryString, "UTF-8"));
        }
        if (body!=null&&body.size()>0) {
            preHash.append(appendBody(body));
        }
        return preHash.toString();
    }

    public static String appendBody(TreeMap<String, String> params) {
        StringBuilder str = new StringBuilder("");
        Set<String> setKey = params.keySet();
        for (String key : setKey) {
            str.append(key).append("=").append(String.valueOf(params.get(key))).append("&");
        }
        String strBody = str.toString();
        if(!StringUtils.isEmpty(strBody)){
            //删除最后一个拼接符
            strBody = strBody.substring(0,strBody.length()-1);
        }
        System.out.println(strBody);
        return strBody;
    }

    public static Mac MAC;

    static {
        try {
            MAC = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeErrorException(new Error("Can't get Mac's instance."));
        }
    }
}
