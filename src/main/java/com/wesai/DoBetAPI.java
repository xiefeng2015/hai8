package com.wesai;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wesai.tests.SigninTest;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.wesai.utils.Constants;
import com.wesai.utils.DateUtil;


@Component
public class DoBetAPI {
    private String accessToken;
    private String responseBody;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @SuppressWarnings("unchecked")
    public void LOTTERY_DOBET(HashMap<String, Object> betData) {
        String testID,statusName,csvResult;
        String waitBonus,message,curDate,newBetcode;
        setAccessToken(SigninTest.access_token);
        testID = Constants.BET_TID();//获取接口地址
        HashMap<String, Object> betMaps = new HashMap<>();
        betMaps = betData;
        //------------------替换动态测试数据
        curDate = DateUtil.getDay().replace("-", "");
        String week = String.valueOf(DateUtil.getWeekOfDate(new Date()));
        newBetcode = String.valueOf(
                betMaps.get("betCodes")).replace("$date", curDate).replace("$week", week);
        betMaps.remove("betCodes");
        betMaps.put("betCodes", newBetcode);
        String strAppend = Boolean.valueOf(betMaps.get("isAppend").toString())?"1":"0";
        betMaps.put("isAppend", strAppend);
        String strStopAfterWin = Boolean.valueOf(betMaps.get("isStopAfterWin").toString())?"1":"0";
        betMaps.put("isStopAfterWin", strStopAfterWin);
        //------------------开始请求API
        responseBody = ApiProvider.requestAppAPI(testID, betMaps, getAccessToken(), 0);
        JSONObject jsonData = JSONObject.fromObject(responseBody);
        Assert.assertEquals(jsonData.get("code").toString(), "200");
        Map<String, String> dataMap = (Map<String, String>) jsonData.get("data");
        message = jsonData.get("message").toString();
        statusName = dataMap.get("statusName").toString();
        boolean resSuccess = Boolean.valueOf(String.valueOf(dataMap.get("isSuccess")));
        csvResult = ApiProvider.getCsvResponseJson(testID, 0);
        waitBonus =JSONObject.fromObject(csvResult).get("statusName").toString();
    }
}
