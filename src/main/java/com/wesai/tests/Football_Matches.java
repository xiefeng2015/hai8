package com.wesai.tests;

import com.wesai.ApiProvider;
import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.utils.Constants;
import com.wesai.utils.PropertiesUtils;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Football_Matches extends AppBaseTest {


    public static String userId;
    public static String mobile;
    public static String access_token;
    private static int isBet = 1;

    private String accessToken;
    private String responseBody;

//    @Test(priority = 2)
//    public void  Foot_Matches() throws IOException {
//        String message,statusName;
//        logger.info("获取当天赛事列表");
//        String testID1 = Constants.Match_TID(super.methodName);
//        HashMap<String, Object> headerMaps1 = new HashMap<>();
//        headerMaps1.put("playingOption[]","hhad");
//        headerMaps1.put("playingOption[]","had");
//        headerMaps1.put("playingOption[]","semi_final");
//        headerMaps1.put("playingOption[]","score");
//        headerMaps1.put("playingOption[]","total");
//        responseBody = ApiProvider.requestAppAPI(testID1,headerMaps1,access_token,0);
//        System.out.println(responseBody);
//        JSONObject jsonData = JSONObject.fromObject(responseBody);
//        Assert.assertEquals(jsonData.get("code").toString(), "200");
//        Map<String, String> dataMap = (Map<String, String>) jsonData.get("data");
//        message = jsonData.get("message").toString();
//        statusName = dataMap.get("statusName").toString();
//    }



}
