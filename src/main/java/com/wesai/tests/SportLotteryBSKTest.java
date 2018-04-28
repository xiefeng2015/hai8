package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.wesai.utils.Constants;
import com.wesai.excelUtils.CsvDataProvider;

public class SportLotteryBSKTest extends AppBaseTest {
    /** 加载外部测试数据驱动 **/
    DoBetAPI doBetAPI = new DoBetAPI();
    public Map<String,Object> BSKData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTERYBSK_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注(竞彩篮球)胜负2串1 **/
    @Test
    public void SPORT_DOBET_BSK001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-胜负玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK001Data"));
    }

    /** 测试接口-Case-投注(竞彩篮球)让分胜负2串1 **/
    @Test
    public void SPORT_DOBET_BSK002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-让分胜负2*1玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK002Data"));
    }

    /** 测试接口-Case-投注(竞彩篮球)胜分差2串1 **/
    @Test
    public void SPORT_DOBET_BSK003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-胜分差2*1玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK003Data"));
    }

    /** 测试接口-Case-投注(竞彩篮球)大小分2串1 **/
    @Test
    public void SPORT_DOBET_BSK004_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-大小分2*1玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK004Data"));
    }

    /** 测试接口-Case-投注(竞彩篮球)混合过关2串1 **/
    @Test
    public void SPORT_DOBET_BSK005_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-混合过关2*1玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK005Data"));
    }

    /** 测试接口-Case-投注(竞彩篮球)单关 **/
    @Test
    public void SPORT_DOBET_BSK880_TEST() throws IOException {
        logger.info("App接口请求-> 投注(竞彩篮球)-单关玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.BSKData("SportLotteryBSK880Data"));
    }
}
