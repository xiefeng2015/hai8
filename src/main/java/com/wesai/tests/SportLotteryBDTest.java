package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.utils.Constants;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SportLotteryBDTest extends AppBaseTest {
    /** 加载外部测试数据驱动 **/
    DoBetAPI doBetAPI = new DoBetAPI();
    public Map<String,Object> BDData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTERYBD_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注(北单)胜平负2串1 **/
    @Test
    public void SPORT_DOBET_BD001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-胜平负玩法,单关投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD001Data"));
    }

    @Test
    public void SPORT_DOBET_BD002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-胜平负玩法，单关+2串1投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD002Data"));
    }

    @Test
    public void SPORT_DOBET_BD003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-胜平负玩法，2串1多赛果投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD003Data"));
    }

    @Test
    public void SPORT_DOBET_BD004_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-比分玩法，单关投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD004Data"));
    }

    @Test
    public void SPORT_DOBET_BD005_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-比分玩法，2串1多赛果投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD005Data"));
    }

    @Test
    public void SPORT_DOBET_BD006_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-比分玩法，单关+2串1投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD006Data"));
    }

    @Test
    public void SPORT_DOBET_BD007_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-进球数玩法，单关+倍数投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD007Data"));
    }

    @Test
    public void SPORT_DOBET_BD008_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-进球数玩法，单关+2串1投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD008Data"));
    }

    @Test
    public void SPORT_DOBET_BD009_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-半全场玩法，单关+2串1投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD009Data"));
    }

    @Test
    public void SPORT_DOBET_BD010_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-半全场玩法，单关投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD010Data"));
    }

    @Test
    public void SPORT_DOBET_BD011_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-胜负过关玩法，3串1多赛果投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD011Data"));
    }

    @Test
    public void SPORT_DOBET_BD012_TEST() throws IOException {
        logger.info("App接口请求-> 投注(北单)-上下单双玩法，投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BDData("SportLotteryBD012Data"));
    }
}
