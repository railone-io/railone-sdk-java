package com.railone.open.api.test;

import com.railone.open.api.dto.DepositFiatAmountReq;
import com.railone.open.api.dto.DepositReq;
import com.railone.open.api.util.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class DepositTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "14db63d7f3614664ad1c71dd134a21dc";
    private static final String apiSecret = "ed8cb3a0-8365-4340-9d9c-33f051eedccd";
    private static final String apiPassphrase = "12345678a";


    @Before
    public void setUp() throws Exception {
        HttpUtil.init(host,apiKey,apiSecret,apiPassphrase);
    }

    @Test
    public void postDepositWithUsdtTest() throws Exception {

        String requestPath = "/api/v1/deposit-transactions";
        String requestQueryStr = "";

        DepositReq req = new DepositReq();
        req.setAcct_no("acct03");
        req.setCard_no("4323592800000050101");

        req.setAmount("20.12345678");
        req.setCoin_type("USDT");
        req.setCust_tx_id(UUID.randomUUID().toString());
        req.setRemark("mock test note");

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }
    @Test
    public void postDepositWithUsdt2Test() throws Exception {

        String requestPath = "/api/v1/deposit-transactions/fiat-amount";
        String requestQueryStr = "";

        DepositFiatAmountReq req = new DepositFiatAmountReq();
        req.setAcct_no("acct03");
        req.setCard_no("4323592800000050101");

        req.setCredited_amount("20");
        req.setCoin_type("USDT");
        req.setCust_tx_id(UUID.randomUUID().toString());
        req.setRemark("mock test note");

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }
    @Test
    public void postDepositWithCryptoTest() throws Exception {

        String requestPath = "/api/v1/deposit-transactions/crypto";
        String requestQueryStr = "";

        DepositReq req = new DepositReq();
        req.setAcct_no("acct03");  //uat02  {"currency_type":"USD","deposit_usdt":"24.91214859","currency_amount":"24.91","exchange_rate":"1","exchange_fee_rate":"0.5","exchange_fee":"25","loading_fee":"0.1875"}
        req.setCard_no("4323592800000050101");//4366354500000011217

        req.setAmount("5");
        req.setCoin_type("ETH");
        req.setCust_tx_id(UUID.randomUUID().toString());
        req.setRemark("mock test note");

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }
    @Test
    public void postDepositWithCrypto2Test() throws Exception {

        String requestPath = "/api/v1/deposit-transactions/crypto/fiat-amount";
        String requestQueryStr = "";

        DepositFiatAmountReq req = new DepositFiatAmountReq();
        req.setAcct_no("acct03");
        req.setCard_no("4323592800000050101");

        req.setCredited_amount("20");
        req.setCoin_type("BTC");
        req.setCust_tx_id(UUID.randomUUID().toString());
        req.setRemark("mock test note");

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }



    @Test
    public void getTxStatusTest() throws Exception {
        String requestPath = "/api/v1/deposit-transactions/"+"2020022109424285101437691"+"/status";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);
    }


    @Test
    public void getDepositListTest() throws Exception {
        String requestPath = "/api/v1/deposit-transactions";
        String requestQueryStr = "acct_no=acct5000&page_num=1&page_size=20&former_time=1578565459&latter_time=1579429459&time_sort=asc";
        HttpUtil.get(requestPath,requestQueryStr);
    }

    @Test
    public void getPriceTest() throws Exception {
        String requestPath = "/api/v1/deposit-transactions/price";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);
    }
}
