package com.wesai.tests;

import com.wesai.DoBetAPI;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wesai.AppBaseTest;
import com.wesai.utils.Constants;
import com.wesai.utils.PropertiesUtils;
import com.wesai.excelUtils.CsvDataProvider;

/**
 * CopyRright     (c)2016-2017
 * Project:       <微赛嗨玩吧API接口测试>
 * Module ID:     <[高频彩-新疆11选5]玩法投注用例>
 * Comments:      <继承自基础测试类，主体测试竞彩篮球所有玩法的接口Case>
 * JDK 版本号:    <JDK1.7>
 * Namespace:     com.wesai.lottery.itest.cases.app
 */
public class SD11x5Test extends AppBaseTest{

    DoBetAPI doBetAPI = new DoBetAPI();

    public SD11x5Test() {
        super(PropertiesUtils.findPropertiesKey("SD11x5"));
    }

    /** 加载外部测试数据驱动 **/
    public Map<String,Object> SD11x5Data(String transfer) throws IOException {
        String className = Constants.DataExcelName.SD11X5_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    @Test
    public void SD11x5_DOBET_001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选5");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5001Data"));
    }

    @Test
    public void SD11x5_DOBET_002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选4");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5002Data"));
    }

    @Test
    public void SD11x5_DOBET_003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选3");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5003Data"));
    }

    @Test
    public void SD11x5_DOBET_004_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选2");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5004Data"));
    }

    @Test
    public void SD11x5_DOBET_005_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选6");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5005Data"));
    }

    @Test
    public void SD11x5_DOBET_006_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选7");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5006Data"));
    }

    @Test
    public void SD11x5_DOBET_007_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-任选8");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5007Data"));
    }

    @Test
    public void SD11x5_DOBET_008_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-前1直选");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5008Data"));
    }

    @Test
    public void SD11x5_DOBET_009_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-前2直选");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5009Data"));
    }

    @Test
    public void SD11x5_DOBET_010_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-前2组选");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5010Data"));
    }

    @Test
    public void SD11x5_DOBET_011_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-前3直选");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5011Data"));
    }

    @Test
    public void SD11x5_DOBET_012_TEST() throws IOException {
        logger.info("App接口请求-> 投注(山东11选5)-前3组选");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.SD11x5Data("C511x5012Data"));
    }
}
