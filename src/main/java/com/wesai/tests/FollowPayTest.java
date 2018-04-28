package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.DoBetAPI;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.utils.Constants;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FollowPayTest extends AppBaseTest {
    DoBetAPI doBetAPI = new DoBetAPI();
    public Map<String,Object> FTData(String transfer) throws IOException {
        String className = Constants.DataExcelName.LOTTERYFT_CSV;
        return new CsvDataProvider().dataProvider(className, transfer);
    }


}
