package com.wesai.excelUtils;

import java.util.HashMap;
import java.util.Map;
import com.wesai.ApiProvider;
import net.sf.json.JSONObject;

public class CsvDataProvider {

    public Map<String, Object> dataProvider(String testCase, String sheetName, int index) {
        String moduleName = null;
        String caseNum = sheetName;
        String className = testCase;
        int dotIndexNum = className.indexOf(".");
        if (dotIndexNum > 0) {
            String substr = className.substring(className.lastIndexOf(".")+1, className.length());
            moduleName = substr.substring(0, substr.length()-4);
        }else {
            moduleName = testCase;
        }
        if (index > 0) {
            return new ExcelDataProvider().GetExcelData(moduleName, caseNum, index);
        }
        return new ExcelDataProvider().GetExcelData(moduleName, caseNum);
    }

    public Map<String, Object> dataProvider(String testCase, String sheetName) {
        return this.dataProvider(testCase, sheetName, 1);
    }

    public JSONObject GetCsvData2JsonObject(HashMap<String, Object> mapdata, String tid, Integer type) {
        String responseBody = ApiProvider.requestAPI(tid, mapdata, type);
        JSONObject jsonObject = JSONObject.fromObject(responseBody);
        return jsonObject;
    }
}
