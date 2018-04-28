package com.wesai.tests;

import com.wesai.ApiProvider;
import com.wesai.BackgroundBaseTest;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.model.IssueLottery;
import com.wesai.user.UserDataBaseTest;
import com.wesai.utils.Constants;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.wesai.DoBetAPI;
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
    @Test(priority = 1,description = "用户请求认证")
    public void USER_AUTHEN_TEST() throws IOException {
        logger.info("App接口请求-> 初始用户认证");
        String testID = Constants.HW_TID(super.methodName);
        HashMap<String, Object> headerMaps = new HashMap<>();
        //请求必带的入参
        headerMaps.put("refresh_token", "");
        headerMaps.put("code", "");
        headerMaps.put("grant_type", "client_credentials");
        responseBody = ApiProvider.requestAuthAPI(testID, headerMaps, 0);
        JSONObject authJson = JSONObject.fromObject(responseBody);
        System.out.println(authJson);
        access_token = authJson.get("access_token").toString();
        Assert.assertEquals("604800", String.valueOf(authJson.get("expried_in")));
    }

    @Test(priority = 2,description = "用户账户登录客户端")
    public void LOTTERY_LOGIN_TEST() throws IOException {
        logger.info("App接口请求-> 用户账号登录客户端");
        String testID = Constants.HW_TID(super.methodName);
        HashMap<String, Object> signMaps = new HashMap<>();
        signMaps = (HashMap<String, Object>) this.UserData("UserData");
        responseBody = ApiProvider.requestAppAPI(testID, signMaps, access_token, 0);
        JSONObject jsonData = JSONObject.fromObject(responseBody);
        Assert.assertEquals(jsonData.get("code").toString(), "200");
        Map<String, String> dataMap =  (Map<String, String>) jsonData.get("data");//从这截止
        /*userId = dataMap.get("userId").toString();
        mobile = dataMap.get("mobile").toString();
        String nickname = String.valueOf(dataMap.get("nickname"));
        Assert.assertEquals(UserDataBaseTest.getNameByUId(userId), nickname);
        doBetAPI = DoBetaAPIBean();
        if (AppBaseTest.mPlayingCode != null) {
            AppBaseTest.issueId = IssueLottery.GetLotteryIssueId(AppBaseTest.mPlayingCode);
            BigDecimal bd = new BigDecimal(AppBaseTest.issueId);
            logger.info("查询测试期号：" + bd.toPlainString());
        } */

    }


    @Test(priority = 3,description = "获取世界杯【猜冠军】赔率接口")
   public void CGJ_odds() throws IOException{
        logger.info("APP接口请求-> 获取世界杯冠军赔率");
        String testID = Constants.Wordcup_Odds(super.methodName);
        HashMap<String, Object> dataMaps = new HashMap<>();
        dataMaps.put("1","1");
        responseBody = ApiProvider.requestAppAPI(testID, dataMaps, access_token, 0);
        JSONObject result_data = JSONObject.fromObject(responseBody);
        JSONObject data = (JSONObject) result_data.get("data");
        JSONArray groups = data.getJSONArray("groups");
        for(int i = 0;i<groups.size();i++){
            JSONObject temp = (JSONObject) groups.get(i);
            String groupName = temp.getString("groupName");
            System.out.println(groupName);
            String teams = temp.getString("teams");
            System.out.println(teams.substring(89,108));
        }
        Assert.assertEquals(result_data.get("code"),200);
   }


   @Test(priority = 4,description = "获取世界杯【冠亚军】赔率")
   public void GYJ_odds() throws IOException{
        logger.info("获取世界杯冠亚军赔率");
        String testID = Constants.Wordcup_GYJ_Odds(super.methodName);
       HashMap<String, Object> dataMaps1 = new HashMap<>();
       dataMaps1.put("1","1");
       responseBody = ApiProvider.requestAppAPI(testID, dataMaps1, access_token, 0);
       JSONObject GYJAPIresult = JSONObject.fromObject(responseBody);
       JSONObject data = (JSONObject) GYJAPIresult.get("data");
       JSONArray matches = data.getJSONArray("matches");
       for(int j = 0;j<matches.size();j++){
           JSONObject temp = (JSONObject) matches.get(j);
           String homeTeamName = temp.getString("homeTeamName");
           String visitingTeamName = temp.getString("visitingTeamName");
           String odds = temp.getString("odds");
           String pr = temp.getString("pr");

           System.out.println(homeTeamName + "\t"+ visitingTeamName + "\t" + odds + "\t" + pr);
       }
       Assert.assertEquals(GYJAPIresult.get("code"),200);
   }


   @Test(priority = 5,description = "获取参与世界杯冠亚军赛选的国家")
   public void GYJ_Country() throws IOException{
        logger.info("获取参与世界杯冠亚军赛选的国家");
        String testID = Constants.GYJ_Country(super.methodName);
       HashMap<String, Object> params = new HashMap<>();
       params.put("1","1");
       responseBody = ApiProvider.requestAppAPI(testID, params, access_token, 0);
       JSONObject test_result = JSONObject.fromObject(responseBody);
       JSONObject data = (JSONObject) test_result.get("data");
       String countrys = data.getString("countrys");
       System.out.println(countrys);

   }


//    @Test(priority = 6,invocationCount = 10,description = "跟单投注")
//    public void ORDER_TEST() throws IOException{
//        logger.info("App接口请求-> 跟单大厅");
//        String testID = Constants.ORDERDETAILS_TID(super.methodName);
//        HashMap<String, Object> orderMaps = new HashMap<>();
//        orderMaps.put("orderId","18041910690042");
//        orderMaps.put("multiple","3");
//        orderMaps.put("betFeeTotal","4800");
//        responseBody = ApiProvider.requestAppAPI(testID, orderMaps, SigninTest.access_token, 0);
//        JSONObject jsonData = JSONObject.fromObject(responseBody);
//        Assert.assertEquals(jsonData.get("code"),200);
//    }
//
//
//    @Test(priority = 7,invocationCount=1,description = "跟单大厅里跟单")
//    public void ORDER_TEST2() throws IOException{
//        logger.info("App接口请求-> 跟单大厅");
//        String testID = Constants.ORDERDETAILS_TID(super.methodName);
//        HashMap<String, Object> orderMaps = new HashMap<>();
//        orderMaps.put("betType","2");
//        orderMaps.put("payType","2");
//        orderMaps.put("orderId","18040911340014");
//        orderMaps.put("multiple","1");
//        orderMaps.put("betFeeTotal","348800");
//        responseBody = ApiProvider.requestAppAPI(testID, orderMaps, SigninTest.access_token, 0);
//        JSONObject jsonData = JSONObject.fromObject(responseBody);
//        Assert.assertEquals(jsonData.get("code"),200);
//    }


    @Test(priority = 8,description = "跟单大厅里所有发单列表")
    public void follow_order_TEST() throws IOException{
        logger.info("App接口请求-> 跟单大厅");
        String testID = Constants.ORDER_TID(super.methodName);
        HashMap<String, Object> dataMaps = new HashMap<>();
        dataMaps.put("orderBy","hot");
        dataMaps.put("nickName","");
        dataMaps.put("filters","");
        dataMaps.put("page","1");
        dataMaps.put("pageSize","20");
        responseBody = ApiProvider.requestAppAPI(testID,dataMaps,SigninTest.access_token,0);
        JSONObject jsonData = JSONObject.fromObject(responseBody);
        Assert.assertEquals(jsonData.get("code"),200);
    }



    //    @Test(priority = 3)
//    public void  Foot_Matches() throws IOException {
//        String message,statusName;
//        logger.info("获取当天赛事列表");
//        String testID1 = Constants.Match_TID(super.methodName);
//        HashMap<String, Object> headerMaps1 = new HashMap<>();
//        headerMaps1.put("playingOption[]","hhad");
////        headerMaps1.put("playingOption[]","had");
////        headerMaps1.put("playingOption[]","semi_final");
////        headerMaps1.put("playingOption[]","score");
////        headerMaps1.put("playingOption[]","total");
//        responseBody = ApiProvider.requestAppAPI(testID1,headerMaps1,SigninTest.access_token,0);
//        JSONObject jsonData = JSONObject.fromObject(responseBody);
//        Assert.assertEquals(jsonData.get("code").toString(), "200");
////        Map<String, String> dataMap = (Map<String, String>) jsonData.get("data");
////        message = jsonData.get("message").toString();
//    }

    @Test(priority = 9,description = "获取竞篮是否有加奖场次")
    public void BSK_Award() throws IOException{
        String testID = Constants.BSk_Award(super.methodName);
        HashMap<String,Object> input_params = new HashMap<>();
        input_params.put("playingCode","BSK005");
        responseBody = ApiProvider.requestAppAPI(testID,input_params,access_token,0);
        JSONObject award_result = JSONObject.fromObject(responseBody);
        Assert.assertEquals(award_result.get("code").toString(), "200");

    }

    @Test(priority = 10,description = "获取竞足是否有加奖场次")
    public void FOT_Award() throws IOException{
        String testID = Constants.BSk_Award(super.methodName);
        HashMap<String,Object> input_params = new HashMap<>();
        input_params.put("playingCode","FT005");
        responseBody = ApiProvider.requestAppAPI(testID,input_params,access_token,0);
        JSONObject award_result = JSONObject.fromObject(responseBody);
        Assert.assertEquals(award_result.get("code").toString(), "200");

    }

    public Map<String,Object> XJ11x5Data(String transfer) throws IOException {
        String className = Constants.DataExcelName.XJ11X5_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
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
