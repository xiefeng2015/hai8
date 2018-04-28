package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DataSourceConst;
import com.wesai.DoBetAPI;
import org.testng.annotations.Test;
import com.wesai.utils.Constants;
import com.wesai.utils.PropertiesUtils;
import com.wesai.excelUtils.CsvDataProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SportOldFootballD14Test extends AppBaseTest {

    DoBetAPI doBetAPI = new DoBetAPI();
    public SportOldFootballD14Test() {
        super(PropertiesUtils.findPropertiesKey("OLDFOOTBALL"));
    }

    /** 加载外部测试数据驱动 **/
    public Map<String,Object> D14Data(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTERYD14_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注(老足彩)14单式彩 **/
    @Test
    public void SPORT_DOBET_D14001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(老足彩)14胜负彩单式玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.D14Data("SportLotteryD14001Data"));
    }

    /** 测试接口-Case-投注(老足彩)14复式彩 **/
    @Test
    public void SPORT_DOBET_D14002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(老足彩)14胜负彩复式玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.D14Data("SportLotteryD14002Data"));
    }

    /** 测试接口-Case-投注(老足彩)单+复式彩 **/
    @Test
    public void SPORT_DOBET_D14003_TEST() throws IOException {
        logger.info("App接口请求-> 投注(老足彩)14胜负彩单+复式玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.D14Data("SportLotteryD14003Data"));
    }
}
