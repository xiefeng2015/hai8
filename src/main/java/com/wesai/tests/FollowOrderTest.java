package com.wesai.tests;

import com.wesai.ApiProvider;
import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import com.wesai.utils.Constants;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FollowOrderTest extends AppBaseTest {
    public static String responseBody;
    SigninTest signintest = new SigninTest();

    @Test
    public void followorder() throws Exception {
        logger.info("App接口请求-> 跟单大厅");
        String testID = Constants.ORDER_TID(super.methodName);
        HashMap<String, Object> dataMaps = new HashMap<>();
        dataMaps.put("orderBy","");
        dataMaps.put("nickName","");
        dataMaps.put("filters","");
        dataMaps.put("page","");
        dataMaps.put("pageSize","");
        responseBody = ApiProvider.requestAppAPI(testID, dataMaps, signintest.access_token, 0);


    }
}
