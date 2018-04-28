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

public class SuperLottoTest extends AppBaseTest {

    DoBetAPI doBetAPI = new DoBetAPI();
    public SuperLottoTest() {
        super(PropertiesUtils.findPropertiesKey("Lotto"));
    }

    public Map<String,Object> LottoData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTO_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    /** 测试接口-Case-投注单式大乐透 **/
    @Test
    public void SUPERLOTT_DOBET_O001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(大乐透)-单式玩法");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.LottoData("SuperLotto001Data"));
    }

//    /** 测试接口-Case-投注复式大乐透 **/
//    @Test
//    public void SUPERLOTT_DOBET_O002_TEST() throws IOException {
//        logger.info("App接口请求-> 投注(大乐透)-复式玩法");
//        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.LottoData("SuperLotto002Data"));
//    }
//
//    /** 测试接口-Case-投注组合单式大乐透 **/
//    @Test
//    public void SUPERLOTT_DOBET_O003_TEST() throws IOException {
//        logger.info("App接口请求-> 投注(大乐透)-组合单式玩法");
//        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.LottoData("SuperLotto003Data"));
//    }
//
//    /** 测试接口-Case-投注组合复式大乐透 **/
//    @Test
//    public void SUPERLOTT_DOBET_O004_TEST() throws IOException {
//        logger.info("App接口请求-> 投注(大乐透)-组合复式玩法");
//        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.LottoData("SuperLotto004Data"));
//    }
}
