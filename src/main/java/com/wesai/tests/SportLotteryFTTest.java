package com.wesai.tests;
import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import org.testng.annotations.Test;
import com.wesai.utils.Constants;
import com.wesai.excelUtils.CsvDataProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SportLotteryFTTest extends AppBaseTest {
    DoBetAPI doBetAPI = new DoBetAPI();
    public Map<String,Object> FTData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTERYFT_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注胜平负2串1 **/
    @Test
    public void SPORT_DOBET_FT001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-胜平负玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT001Data"));
        //this.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT001Data"));
    }

    /** 测试接口-Case-投注比分2串1 **/
    @Test
    public void SPORT_DOBET_FT002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-比分玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT002Data"));
    }

    /** 测试接口-Case-投注总进球数2串1 **/
    @Test
    public void SPORT_DOBET_FT003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-总进球数玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT003Data"));
    }

    /** 测试接口-Case-投注半全场玩法2串1 **/
    @Test
    public void SPORT_DOBET_FT004_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-半全场玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT004Data"));
    }

    /** 测试接口-Case-投注胜不胜玩法2串1 **/
    @Test
    public void SPORT_DOBET_FT880_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-2选1玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT880Data"));
    }

    /** 测试接口-Case-投注单关玩法 **/
    @Test
    public void SPORT_DOBET_FT881_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-单关玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT881Data"));
    }

    /** 测试接口-Case-投注混合过关玩法2串1 **/
    @Test
    public void SPORT_DOBET_FT005_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-混合过关玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT005Data"));
    }

    /** 测试接口-Case-投注让球胜平负玩法2串1 **/
    @Test
    public void SPORT_DOBET_FT006_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩足球)-让球胜平负玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.FTData("SportLotteryFT006Data"));
    }
}
