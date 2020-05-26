package com.railone.open.api.test;

import com.alibaba.fastjson.JSONObject;
import com.railone.open.api.util.HmacUtil;
import org.junit.Test;

import java.util.TreeMap;

/**
 * @author Sheldon Zhao
 * @date 3/27/20
 */
public class NotificationTest {
    @Test
    public void notificationTest() {
        //what you receive in header
        String timeStamp = "1585556940084";
        String signature = "Qb68D7pqh0cn/tmVxHH++9NMI3N2Ysrti6ZSC2a0pZM=";
        //action, params and your secret
        String action = "kyc-status";
        String secret = "ba3a3c0c38dc434eb25225ab06135743";
        String params = "{\n" +
                "    \"action\": \"kyc-status\",\n" +
                "    \"events\": [\n" +
                "        \"{\\\"id\\\":\\\"bc76488ddda4\\\",\\\"create_time\\\":1585293811000,\\\"params\\\":{\\\"card_type_id\\\":\\\"50010003\\\",\\\"acct_no\\\":\\\"032500004\\\",\\\"status\\\":1}}\"\n" +
                "    ]\n" +
                "}";
        TreeMap<String, Object> treeMap = JSONObject.parseObject(params, TreeMap.class);

        //verify
        try {
            String sign = HmacUtil.sign(timeStamp, action, treeMap, secret);
            System.out.println(sign);
            if (sign.equals(signature)) {
                System.out.println("signature is right");
            }else {
                System.out.println("signature is wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
