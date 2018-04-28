package com.wesai.tests;

import com.wesai.ApiProvider;
import com.wesai.BackgroundBaseTest;
import com.wesai.user.UserDataBaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.wesai.utils.Constants;
import java.util.HashMap;

public class RechargeTest extends BackgroundBaseTest {
    public static Logger logger = Logger.getLogger(RechargeTest.class);
    public String responseBody;


    @Test
    public void COIN_RECHARGE_TEST() {
        String testID = Constants.AN_TID(super.methodName);
        logger.info("『嗨玩吧』接口请求-> 充值金额");
        String str = "15882066239";
        HashMap<String, Object> rechargeMaps = new HashMap<>();
        rechargeMaps.put("userId","1512549452101000019909");
        //rechargeMaps.put("userId", UserDataBaseTest.getUserId(str));
        rechargeMaps.put("type", "3");
        rechargeMaps.put("num", "100");
        responseBody = ApiProvider.requestAPI(testID, rechargeMaps, client, 1);
        Assert.assertEquals("<br>充值零钱(分):100", responseBody);;
    }
}
