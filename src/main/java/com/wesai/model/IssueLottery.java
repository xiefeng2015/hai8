package com.wesai.model;

import com.wesai.ApiProvider;
import com.wesai.tests.SigninTest;
import com.wesai.utils.Constants;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IssueLottery {
    public static String responseBody;

    @SuppressWarnings("unchecked")
    public static String GetLotteryIssueId(String playCode) throws IOException {
        String testID = Constants.ISSUE_TID();
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("playingCode", playCode);
        responseBody = ApiProvider.requestAppAPI(testID, dataMap, SigninTest.access_token, 0);
        JSONObject jsonData = JSONObject.fromObject(responseBody);
        Map<String, ?> resultData = ((Map<String, Object>) jsonData.get("data"));
        return String.valueOf(resultData.get("issueId"));

    }




}

