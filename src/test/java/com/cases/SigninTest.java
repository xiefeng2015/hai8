package com.cases;

import com.wesai.BackgroundBaseTest;
import com.wesai.DoBetAPI;

import com.wesai.AppBaseTest;
import com.wesai.BackgroundBaseTest;
import com.wesai.user.UserDataBaseTest;
import com.wesai.utils.Constants;
import com.wesai.ApiProvider;
import com.wesai.excelUtils.CsvDataProvider;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.wesai.model.IssueLottery;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SigninTest extends BackgroundBaseTest {
    public static String userId;
    public static String mobile;
    public static String access_token;
    private static int isBet = 1;

    /**
     * 前端请求参数
     * @throws IOException
     */
    @Test
    public void USER_AUTHEN_TEST() throws IOException {
        logger.info("App接口请求-> 初始用户认证");
        String testID = Constants.HW_TID(super.methodName);
        HashMap<String, Object> headerMaps = new HashMap<>();
        //请求必带的入参
        headerMaps.put("refresh_token", "");
        headerMaps.put("code", "");
        headerMaps.put("grant_type", "client_credentials");
        //==========get token
//		headerMaps.put("refresh_token", "");
//		headerMaps.put("code", "a1c21a4a44efd1dbd912e4eaeee16ac5");
//		headerMaps.put("grant_type", "authorization_code");
        responseBody = ApiProvider.requestAuthAPI(testID, headerMaps, 0);
        JSONObject authJson = JSONObject.fromObject(responseBody);
        access_token = authJson.get("access_token").toString();
        Assert.assertEquals("604800", String.valueOf(authJson.get("expried_in")));
    }

    @Test@SuppressWarnings("unchecked")
    public void LOTTERY_LOGIN_TEST() throws IOException {
        logger.info("App接口请求-> 用户账号登录客户端");
        String testID = Constants.HW_TID(super.methodName);
        HashMap<String, Object> signMaps = new HashMap<>();
        signMaps = (HashMap<String, Object>) this.UserData("UserData");
        responseBody = ApiProvider.requestAppAPI(testID, signMaps, access_token, 0);
        JSONObject jsonData = JSONObject.fromObject(responseBody);
        Assert.assertEquals(jsonData.get("code").toString(), "200");
        Map<String, String> dataMap =  (Map<String, String>) jsonData.get("data");
        userId = dataMap.get("userId").toString();
        mobile = dataMap.get("mobile").toString();
        String nickname = String.valueOf(dataMap.get("nickname"));
        Assert.assertEquals(UserDataBaseTest.getNameByUId(userId), nickname);
        doBetAPI = DoBetaAPIBean();
        if (AppBaseTest.mPlayingCode != null) {
            AppBaseTest.issueId = IssueLottery.GetLotteryIssueId(AppBaseTest.mPlayingCode);
            BigDecimal bd = new BigDecimal(AppBaseTest.issueId);
            logger.info("查询测试期号：" + bd.toPlainString());
        }

    }

    public static DoBetAPI DoBetaAPIBean() {
        if (isBet == 1) {
            DoBetAPI doBetAPI = (DoBetAPI) ctx.getBean("doBetAPI");
            return doBetAPI;
        }
        return null;
    }

    public Map<String,Object> UserData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOGIN_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

}
