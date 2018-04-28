package com.wesai.tests;

import com.wesai.AppBaseTest;
import com.wesai.WordCupApi;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class WordCupTest extends AppBaseTest{
    WordCupApi wordcupapi = new WordCupApi();
    @Test
    public void SUPERLOTT_DOBET_O001_TEST() throws IOException {
        logger.info("App接口请求-> 投注(大乐透)-单式玩法");
        HashMap<String, Object> paramsData = new HashMap<>();
        wordcupapi.WordCup((HashMap<String, Object>)paramsData);
    }
}
