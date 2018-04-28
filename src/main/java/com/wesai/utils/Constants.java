package com.wesai.utils;
import com.wesai.ApiProvider;
import com.wesai.excelUtils.ExcelProvider;

public class Constants {
    //--------------------------------------------------------------
    //定义csv的sheet名称
    public static final String TD = "TestData";
    public static String testID = "";
    public static class CsvSheetName {
        public static final String VD  =  "VoucherData";
        public static final String RVD =  "RechargeData";
        public static final String MVD =  "ArtificialData";
        public static final String LVD =  "LaunchVData";

    }
    //--------------------------------------------------------------

    public static class DataExcelName {
        //==============================================================
        //定义外部数据源csv名称
        public static final String LOGIN_CSV      = "Login";
        public static final String AUTHEN_CSV     = "Authentication";
        public static final String VOUCHER_CSV    = "Voucher";
        public static final String VOUTASK_CSV    = "VoucherTask";
        public static final String LOTTERYFT_CSV  = "SportLotteryFT";
        public static final String LOTTERYBSK_CSV = "SportLotteryBSK";
        public static final String LOTTERYD14_CSV = "SportLotteryD14";
        public static final String LOTTO_CSV      = "SuperLotto";
        public static final String DC_CSV         = "SportLotteryDC";
        public static final String SD11X5_CSV     = "SD11x5";
        public static final String XJ11X5_CSV     = "XJ11x5";
        public static final String GD11X5_CSV     = "GD11X5";
        public static final String D5_CSV         = "SportLotteryD5";
        public static final String LOTTERYBD_CSV  = "SportLotteryBD";
        public static final String FollowOrder_CSV = "FollowOrder";

        //==============================================================
    }

    //==============================================================
    //定义测试用例编号
    public static String TID(int rowIndex, int sheetId) {
        String testcaseId = "TID_";
        for (int i= 1;i < ExcelProvider.getLastRowCount(); i++) {
            testcaseId += i;
            testcaseId = (ApiProvider.getCsvTID(rowIndex, sheetId));
        }
        return testcaseId;
    }

    public static String AN_TID(String method) {
        return new Constants().getTestIdName(method, 1);
    }

    public static String HW_TID(String method) {
        return new Constants().getTestIdName(method, 0);
    }




    //-----------此处目前采用硬编码处理---------------------
    public static String BET_TID(String...method) {
        return "APIv2_LOTTERY_DOBET";
    }

    public static String ISSUE_TID(String...method) {
        return "APIv2_LOTTERY_ISSUE";
    }

    public static String ORDER_TID(String...method){
        return "APIv2_LOTTERY_FOLLOWOrder";
    }

    public static String Match_TID(String...method){
        return "APIv2_Foot_Matches";
    }

    public static String ORDERDETAILS_TID(String...method){
        return "APIv2_LOTTERY_DOBET1";
    }

    public static String ORDER_SLOGAN(String...method){
        return "APIv2_LOTTERY_slogan";
    }

    public static String Wordcup_Odds(String...method){return "APIv2_LOTTERY_Wordcup_Odds";}

    public static String Wordcup_GYJ_Odds(String...method){
        return "APIv2_wordcup_GYJ_odds";
    }

    public static String GYJ_Country(String...method){
        return "APIv2_GYJ_Country";
    }

    public static String BSk_Award(String...method){
        return "APIv2_BSK_Award";
    }
    //------------------------------------------------------

    private String getTestIdName(String method, int sheetId) {
        String testcaseName = "", testIdName = "";
        for (int i= 0;i < ExcelProvider.getLastRowCount()+1; i++) {
            testcaseName = (ApiProvider.getCsvTID(i, sheetId));
            String newStr;
            if (sheetId == 0) {
                newStr = testcaseName.substring(testcaseName.indexOf("API") + 6,
                        testcaseName.length()) + "_TEST";
            }else {
                newStr = testcaseName.substring(testcaseName.indexOf("API") + 4,
                        testcaseName.length()) + "_TEST";
            }
            if (method.equals(newStr)) {
                testIdName = testcaseName;
                break;
            }
        }
        return testIdName;
    }

    public static final String TID_OP      = ApiProvider.getCsvTID(1, 1);
    public static final String TID_HW      = ApiProvider.getCsvTID(1, 2);
    //==============================================================

    public static void main(String[] args) {
        System.out.println(AN_TID(""));
    }
}


