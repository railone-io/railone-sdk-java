package com.railone.open.api.test;

import com.alibaba.fastjson.JSON;
import com.railone.open.api.util.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class EventTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "14db63d7f3614664ad1c71dd134a21dc";
    private static final String apiSecret = "ed8cb3a0-8365-4340-9d9c-33f051eedccd";
    private static final String apiPassphrase = "12345678a";


    @Before
    public void setUp() throws Exception {
        HttpUtil.init(host,apiKey,apiSecret,apiPassphrase);
    }


    @Test
    public void getEventsTest() throws Exception {
        String requestPath = "/api/v1/events";
        String requestQueryStr = "";
        HttpUtil.get(requestPath,requestQueryStr);
    }


    @Test
    public void putEventsTest() throws Exception {
        String requestPath = "/api/v1/events";
        String requestQueryStr = "";
        Map map = new HashMap<>();
        List list = new ArrayList<>();
        list.add("123");
        map.put("event_id",list);
        HttpUtil.put(requestPath,requestQueryStr,JSON.toJSONString(map));
    }

    @Test
    public void getEventsTestTest() throws Exception {
        String requestPath = "/api/v1/events/test";
        String requestQueryStr = "";
        HttpUtil.post(requestPath,requestQueryStr,JSON.toJSONString(new HashMap<>()));
    }
}
