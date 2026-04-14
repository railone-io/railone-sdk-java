package com.railone.open.api.test;

import com.github.ontio.account.Account;
import com.github.ontio.common.Helper;
import com.github.ontio.crypto.SignatureScheme;
import com.github.ontio.sdk.manager.ECIES;
import com.railone.open.api.dto.CardInfoReq;
import com.railone.open.api.util.Base64Utils;
import com.railone.open.api.util.HttpUtil;
import com.railone.open.api.util.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class RSATest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "14db63d7f3614664ad1c71dd134a21dc";
    private static final String apiSecret = "ed8cb3a0-8365-4340-9d9c-33f051eedccd";
    private static final String apiPassphrase = "12345678a";


    @Before
    public void setUp() throws Exception {
        HttpUtil.init(host,apiKey,apiSecret,apiPassphrase);
    }
    @Test
    public void eciesTest() throws Exception {
        Account account = new Account(SignatureScheme.SHA256WITHECDSA);
        System.out.println("privatekey:"+Helper.toHexString(account.serializePrivateKey()));
        System.out.println("publickey:"+Helper.toHexString(account.serializePublicKey()));
        String msg = "12345678";
        String[] endata = ECIES.Encrypt(Helper.toHexString(account.serializePublicKey()),msg.getBytes());
        byte[] dedata = ECIES.Decrypt(Helper.toHexString(account.serializePrivateKey()),endata);
        System.out.println(new String(dedata));
    }
    @Test
    public void rsaTest() throws Exception {

        Map<String, Object> map = RsaUtils.genKeyPair();
        String publicKey = RsaUtils.getPublicKey(map);
        System.out.println("String publicKey= \""+publicKey+"\";");
        String privateKey = RsaUtils.getPrivateKey(map);
        System.out.println("String privateKey= \""+privateKey+"\";");
        String data = "12345678a";
        byte[] endata = RsaUtils.encryptByPublicKey(data.getBytes(),publicKey);
        System.out.println(Base64Utils.encode(endata));
        String rspContent = new String(RsaUtils.decryptByPrivateKey(endata, privateKey));
        System.out.println(rspContent);

    }

    @Test
    public void getBankVirtualcardByPostTest() throws Exception {
        String publicKey= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDtxc+w3LlhtF3DcbgS8zqvjYs8Z+s03DrtbQb8iigeMAbKjXLbrWZwX6IprmVRandLuM3PV3UU7L4SCdJZBRUjgEe0q3F/kUe1XwFhsl4aoW9FHKK/d/em50qHSLXw/KPX2HyZ9Ey9G/bV6OwJXvkUYfStBjHNgPlwFca17QhuQIDAQAB";
        String privateKey= "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIO3Fz7DcuWG0XcNxuBLzOq+Nizxn6zTcOu1tBvyKKB4wBsqNctutZnBfoimuZVFqd0u4zc9XdRTsvhIJ0lkFFSOAR7SrcX+RR7VfAWGyXhqhb0Ucor9396bnSodItfD8o9fYfJn0TL0b9tXo7Ale+RRh9K0GMc2A+XAVxrXtCG5AgMBAAECgYAi/YadU8q4EuKeX/iPKVPcoH8/3Uhv3xPGalTYf7IvPyS5krMLwfNYT0DQCIqQjxsa+RO/XvwIJdwLfQ+CvaVwlr44f7ytmFAiKlWGGy7xIrfAVzyxZiEVJMLpiBxwhPjAm0Z1IpuQygXxfMJ1ZVD3vltwt5yWGE6cCaqvU8kR6QJBAM3LTkrEm9xVxTCj3fQzI+qk4kwLZREDb/AnZ9rJKFmgAD5JmCl/M8PJty/ucXcKQuXU3a6zGZsRNLLWlSjlbe8CQQCj2T+Ezjx/i7yns5fugJ87MlvuD1NKUFdo94EaxF6cF5n7BmhI9LFhqXi5KaQVuITB6DMsyQYkCiABq1OBVhLXAkAw7FAkfjD/ZHSIZ6xwTWgQdDpIEb1pGgQWd4e8/21UQTFNnXlLBC5uMRoXjvvybMISmVRKH9HKh4Cbs1+qZUCJAkEAihSFgShEt8BNZo7lVSu0BTE1Y/QqXxBB+cXLWYFvsd/59iC6NfFwozss7+51x5BO4RMMPYvTzv9xZba6kt601QJBAJ6A5/YzzPU9Aeiy43dL59GHYrPG8NHatUcY2GiMuvrXREWzde/s261EIK3+6etVTQuqJkmighNCDsACxcBZn1U=";

        String requestPath = "/api/v1/bank/virtualcard";
        String requestQueryStr = "";
        CardInfoReq req = new CardInfoReq();
        req.setCard_no("4389229720000052395");
        req.setPublickey(publicKey);
        HttpUtil.post(requestPath,requestQueryStr,req.toString());


        String endata = "RtCymCstsdJEhCFf6BNqBqnwPiUPK+JsX3eBx2tBFTVbsKE1A0yS5Tr70q19t1TbPcmFkYDEdD2U1bvzoI3wFC+RuB2/qWRJyFxwnsNp6kOHrPHYTJcK1wlr0KFWdqqAPSjtDWNZdNoY8VmjcSRRmyzNhv7NmKhTS36p3QEiOZ0w1Q+OgWDKO+twShnehwg3HX4bvfsWawIJYYwIIjt+9A7pg92j5FKAAwad/u7NZQHo7RapGjK+eebRdbQQTHw8EK3GDAG5ydRn6O2bZTE/2YMj2VbBAFJX5APLMxLcXA9ADtwYoo8qgd+tpFSIIYUuoXBo8GC7UjP2vgTRrk3Q5ihan/rHQU7L2EL6Q1f7oTKMkngjKhQckf2BJt/c/g4Qj8FzhgonvVeQDJzguaZP8T/Rxqgrqhx2AHzFXWu/6DOMKRAvGlmAqUSn/No9jUMEdK0IUe52lou/sxJUrLia4bzc36kOYCGQKqqtAlrN0eKeDK3k9K9y7uNWZXcdO4IdZzVWCJ+YHHVFYJ+YxIWVtoW3U6+r74ebPEB8pyORWGTdHUXtThqZQoYxR4SDcTmVOf4lYE4mghZyuBpk/PJjuPGFtlZGSn2b/o9ksqyd3cHJeQvqzMW0W6taMsBYFVEEU2Q2WVW7YbOTfPberIdXmXx8VdVRRZf7kyvIc196t5o=";
        String rspContent = new String(RsaUtils.decryptByPrivateKey(Base64Utils.decode(endata), privateKey));
        System.out.println(rspContent);
    }

}
