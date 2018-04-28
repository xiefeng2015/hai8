package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import com.wesai.utils.PropertiesUtils;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.utils.Constants;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XJ11x5Test extends AppBaseTest {

    DoBetAPI doBetAPI = new DoBetAPI();

    public XJ11x5Test(){
        super(PropertiesUtils.findPropertiesKey("SD11x5"));
    }
    /** 加载外部测试数据驱动 **/
    public Map<String,Object> XJ11x5Data(String transfer) throws IOException {
        String className = Constants.DataExcelName.XJ11X5_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }

    @Test
    public void XJ11x5_DOBET_001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(新疆11选5)-任选2");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.XJ11x5Data("XJ11x5001Data"));
    }

    @Test
    public void XJ11x5_DOBET_002_TEST() throws IOException {
        logger.info("App接口请求-> 投注(新疆11选5)-任选2单式投注");
        doBetAPI.LOTTERY_DOBET((HashMap<String, Object>)this.XJ11x5Data("XJ11x5002Data"));
    }

}
