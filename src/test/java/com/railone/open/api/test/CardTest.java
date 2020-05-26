package com.railone.open.api.test;

import com.railone.open.api.dto.ActiveCardReq;
import com.railone.open.api.dto.AttachmentReq;
import com.railone.open.api.dto.NewCardReq;
import com.railone.open.api.util.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * @author zhouq
 * @version 1.0
 * @date 2019/12/11
 */
public class CardTest {

    String host = "https://api.sandbox.railone.io";
    private static final String apiKey = "14db63d7f3614664ad1c71dd134a21dc";
    private static final String apiSecret = "ed8cb3a0-8365-4340-9d9c-33f051eedccd";
    private static final String apiPassphrase = "12345678a";

    @Before
    public void setUp() throws Exception {
        HttpUtil.init(host,apiKey,apiSecret,apiPassphrase);
    }

    @Test
    public void postNewCardTest() throws Exception {

        String requestPath = "/api/v1/debit-cards";
        String requestQueryStr = "";

        NewCardReq req = new NewCardReq();
        req.setAcct_no("acct5000");
        req.setCard_type_id("50000001");
        req.setCust_tx_id(UUID.randomUUID().toString());
        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }


    @Test
    public void postActivateCardAttachmentTest() throws Exception {

        String requestPath = "/api/v1/debit-cards/attachment";
        String requestQueryStr = "";

        AttachmentReq req = new AttachmentReq();
        req.setCard_no("4366520800000050100");
        String imgBase64 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADMAAAAyCAMAAADGIxO9AAABdFBMVEUAAAAA//+AgP8zmf9Jkv9Vqv9Nmf9Gov9Aqv9Onf9JpP9Eqv9Qn/9Lpf9Hqv9Dof9Npv9Jnv9Gov9Dpv9Kn/9Ho/9Fp/9Mof9JpP9Gp/9In/9Lpf9Ho/9HoP9KpP9Jof9Hpf9Kov9Go/9Iov9Ho/9Jov9Iov9JpP9Iov9Ho/9Jov9Hof9Iov9Jo/9IpP9Jo/9Iov9Ho/9Iov9Io/9Iov9JpP9Iov9Ho/9Io/9IpP9Hov9IpP9JpP9Io/9Io/9Io/9Io/9Hov9Io/9IpP9Ho/9Jov9Io/9Io/9Io/9IpP9Io/9Io/9Io/9Ho/9Iov9Io/9Io/9Jo/9Io/9Io/9Ho/9Io/9Io/9Io/9Jo/9IpP9Io/9Ho/9Iov9Io/9Io/9Jo/9Io/9IpP9Io/9Jo/9Io/9Io/9Io/9Io/9Jo/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/9Io/////9nZg6jAAAAenRSTlMAAQIFBwkKCwwNDg8QERITFBUWFxgZGhscHSAiJCstMTY3Ojw9QkdJSktNT1VbXF5gYWNneXt8fYCDhIaJipucpKirra+ztLW3uL3AwsjJysvMzc7P0NHS09TV1tfY2drb3+Dh5OXm5+jp6uvs7vHz9PX3+Pn6+/z9/pduSYEAAAABYktHRHtP0rX8AAACGElEQVRIx5XWWVvTQBQG4K+oiG1jm2ap1n0XRa0b1gVRWVxwAWwbaJZaQBAxuGLw/HovKjqTzILnKk9y3nyTZCbPANnKHbs5PvM+juM4nBq7bGYb7PSJo/d6xNb2i+uDqRafRyeebFOmPt4pcE3EImtcIIiI1m8MsIZ6tZ3jkU2S1ssqayhw+o/e+EWKWj3FGlqqAdjziNT1fYQ1FDpA8a3G0NYwayh0gVJTh76eYQ0t1YDCKx3acFlDgbObpKc51uwyqc4ZCmyg1NKYlSHOUK8GFF5r0Chv6N0hPVof5A35FlBuq9GVlKFuFSiqk56lDXUswPSUs+FA2vST3qjQhYyhRV3S3azRJk0IDC1UgMqC1LREhrouUJyVmTWhoUiFPosNeSZQWRRfSySGPBOwOhLzTYIiFzBmxWZD9qihCxhzQtORvtN2GbB8kZmUfzxJUoL7ilnSKgO2nzXnVdMxdACznTH5LRVqlgA7SBtMkTbJS5tr6qXcLAFOkDJ7V9UoSCclAG5p/k6BzaMEQP6DBs0fBNyQM7hK/5WUAMDAcx2aNwA3Yg2Mng759r/l3jc4+UWH5gyg2mUNhn9qUR6oRqzBuU2NeZDDn+H9NTi9phLJ7X6XG7EGpmLiLZ/d6XIj1gCXliUbg8Y+5tYeZ1BsfBIM6/FxrsntpHZZ++vTP/ilOnpEu3sDhi6OTUdxHMcrMw/rhwVbQvwGOaukvpva6/sAAAAASUVORK5CYII=";
        req.setActive_doc(imgBase64);
        //req.setPoa_doc("")

        HttpUtil.post(requestPath,requestQueryStr,req.toString());
    }

    @Test
    public void getCardsTest() throws Exception {
        String requestPath = "/api/v1/debit-cards";
        String requestQueryStr = "page_num=1&page_size=20&former_time=1578565459&latter_time=1579429459&time_sort=asc";
        HttpUtil.get(requestPath,requestQueryStr);
    }

    @Test
    public void putActiveCardTest() throws Exception {

        String requestPath = "/api/v1/debit-cards/status";
        String requestQueryStr = "";

        ActiveCardReq req = new ActiveCardReq();
        req.setAcct_no("acct001");
        req.setCard_no("822848003056012011");
        HttpUtil.put(requestPath,requestQueryStr,req.toString());
    }

}
