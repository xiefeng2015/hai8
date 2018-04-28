package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import org.testng.annotations.Test;
import com.wesai.utils.PropertiesUtils;
import com.wesai.utils.Constants;
import com.wesai.excelUtils.CsvDataProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SportLotteryDCTest extends AppBaseTest {

    DoBetAPI doBetAPI = new DoBetAPI();
    public SportLotteryDCTest() {
        super(PropertiesUtils.findPropertiesKey("DC"));
    }

    public Map<String,Object> DCData(String transfer) throws IOException {
        String className = Constants.DataExcelName.DC_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注单式双色球 **/
    @Test(invocationCount=1)
    public void SUPERDC_DOBET_O001_TEST() throws IOException {
        int i;
        logger.info("App接口请求-> 投注(双色球)-单式玩法");
        for(i = 0;i<500;i++) {
            doBetAPI.LOTTERY_DOBET((HashMap<String, Object>) this.DCData("SportLotteryDC001Data"));
        }
    }

    /** 测试接口-Case-投注复式双色球(+蓝球) **/
    @Test
    public void SUPERDC_DOBET_O002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(双色球)-复式双色球(+蓝球)玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.DCData("SportLotteryDC002Data"));
    }

    /** 测试接口-Case-投注复式双色球(+红球) **/
    @Test
    public void SUPERDC_DOBET_O003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(双色球)-复式双色球(+红球)玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.DCData("SportLotteryDC003Data"));
    }

    /** 测试接口-Case-投注复式双色球(+红蓝球) **/
    @Test
    public void SUPERDC_DOBET_O004_TEST() throws IOException {
        logger.info("App接口请求-> 投注(双色球)-复式双色球(+红蓝球)玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.DCData("SportLotteryDC004Data"));
    }

    /** 测试接口-Case-投组合单式双色球 **/
    @Test
    public void SUPERDC_DOBET_O005_TEST() throws IOException {
        logger.info("App接口请求-> 投注(双色球)-组合单式双色球玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.DCData("SportLotteryDC005Data"));
    }
}
