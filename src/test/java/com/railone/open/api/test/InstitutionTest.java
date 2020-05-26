package com.railone.open.api.test;

import com.railone.open.api.dto.CalcCryptoReq;
import com.railone.open.api.dto.CalcCurrencyReq;
import com.railone.open.api.dto.PublickeyReq;
import com.railone.open.api.util.HttpUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class InstitutionTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "14db63d7f3614664ad1c71dd134a21dc";
    private static final String apiSecret = "ed8cb3a0-8365-4340-9d9c-33f051eedccd";
    private static final String apiPassphrase = "12345678a";


    @Before
    public void setUp() throws Exception {
        HttpUtil.init(host,apiKey,apiSecret,apiPassphrase);
    }


    @Test
    public void getCardTypeListTest() throws Exception {
        String requestPath = "/api/v1/institution/card/type";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);
//
    }



    @Test
    public void getBalanceTest() throws Exception {
        String requestPath = "/api/v1/institution/balance";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);
    }

    @Test
    public void postPublickeyTest() throws Exception {
        String requestPath = "/api/v1/institution/publickey";
        String requestQueryStr = "";
        PublickeyReq req = new PublickeyReq();
        req.setPublic_key("031194af2b8ad8cba709509a630dfcc3746c24dfbbe9af48264df5663ad308e16f");
        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }

    @Test
    public void getInstitutionInfoTest() throws Exception {
        String requestPath = "/api/v1/institution/info";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);

    }


    @Test
    public void getRatesTest() throws Exception {
        String requestPath = "/api/v1/institution/rates";
        String requestQueryStr = "card_type_id="+"70000001";
        HttpUtil.get(requestPath,requestQueryStr);
    }

    @Test
    public void getEstimationCurrencyTest() throws Exception {

        String requestPath = "/api/v1/institution/estimation/currency";
        String requestQueryStr = "";

        CalcCurrencyReq req = new CalcCurrencyReq();
        req.setCard_type_id("50000001");
        req.setCoin_amount("0.1");
        req.setCoin_type("BTC");
        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }

    @Test
    public void getEstimationCryptoTest() throws Exception {

        String requestPath = "/api/v1/institution/estimation/crypto";
        String requestQueryStr = "";

        CalcCryptoReq req = new CalcCryptoReq();

        req.setCard_type_id("50000001");
        req.setCurrency_amount("10");
        req.setCoin_type("USDT");

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }
}
