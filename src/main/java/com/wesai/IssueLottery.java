package com.wesai;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wesai.tests.SigninTest;
import net.sf.json.JSONObject;
import com.wesai.utils.Constants;


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
