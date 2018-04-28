package com.wesai;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.wesai.BackgroundBaseTest;
import com.wesai.httpUtils.HttpUtils;
import com.wesai.model.ResponseBean;
import com.wesai.utils.ConfigLocation;
import com.wesai.excelUtils.ExcelProvider;
import com.wesai.httpUtils.ReponseUtil;

public class ApiProvider {

    public static Logger logger = Logger.getLogger(ApiProvider.class);

    public ApiProvider(){}

    public static List<?> getApiData(String tid){
        int DataRow = 1;
        List<?> apiData = null;
        try {
            List<?> tidList;
            tidList = ExcelProvider.getColData(0);
            for (int i = 1;i<tidList.size();i++){
                String excelTid = (String) tidList.get(i);
                logger.info(excelTid);
                if(excelTid.equals(tid)){
                    DataRow = i;
                    logger.info("行数：" +i);
                    break;
                }
            }

            apiData = ExcelProvider.getRowData(DataRow);
        }catch (InvalidFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return apiData;
    }

    /**
     * 根据指定的索引号找出需要的api所在行
     * @param index
     * @return
     */
    public static List<?> getApiData(int index) {
        int DataRow = 1;
        List<?> apiData = null;
        try {
            List<?> tidList;
            tidList = ExcelProvider.getColData(0);
            for (int i = 1; i < tidList.size(); i++) {
                if (i == index) {
                    DataRow = i;
                    //logger.info("行数："+ i);
                    break;
                }
            }
            //找出api的行数据
            apiData = ExcelProvider.getRowData(DataRow);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiData;
    }

    private static String ExcelSheetName(Integer t) {
        return ExcelProvider.sheetname = t > 0  ? "ADMIN" : "LOTTERY";
    }

    public static String requestAuthAPI(String tid, Map<String, Object> data, int sheet) {
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = (String) apiData.get(5);
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        System.out.println(stringBuffer);
        httpResponse = HttpUtils.getInstance().authPost(stringBuffer.toString(), data, BackgroundBaseTest.client, null);
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    public static String requestAppAPI(String tid, Map<String, Object> data, String accessToken, int sheet) {
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        String getorpost = ((String) apiData.get(2)).toLowerCase();
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = (String) apiData.get(5);
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        if (getorpost.equals("post")) {
            httpResponse = HttpUtils.getInstance().appPost(stringBuffer.toString(), data, BackgroundBaseTest.client, accessToken);
        }
        if (getorpost.equals("get")) {
            httpResponse = HttpUtils.getInstance().appGet(stringBuffer.toString(), data, BackgroundBaseTest.client, accessToken);
        }
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    public static String requestAPI(String tid, Map<String, Object> data, int sheet) {
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        // 从excel 拿数据
        List<?> apiData = getApiData(tid);
        String getorpost = ((String) apiData.get(2)).toLowerCase();
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = (String) apiData.get(5);
        // URI 拼接
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        System.out.println(stringBuffer);
        if (getorpost.equals("post")) {
            httpResponse = HttpUtils.getInstance().post(stringBuffer.toString(), data, BackgroundBaseTest.client, null);
        }
        if (getorpost.equals("get")) {
            httpResponse = HttpUtils.getInstance().get(stringBuffer.toString(), data, BackgroundBaseTest.client, null);
        }
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    public static String requestAPI(String tid, Map<String, Object> data, String keycode, int sheet){
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ApiProvider.ExcelSheetName(sheet);
        // 从excel 拿数据
        List<?> apiData = getApiData(tid);
        String getorpost = ((String) apiData.get(2)).toLowerCase();
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = (String) apiData.get(5);
        // URI 拼接
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        logger.info(stringBuffer);
        if (getorpost.equals("post")) {
            httpResponse = HttpUtils.getInstance().post(stringBuffer.toString(), data, BackgroundBaseTest.client, null, keycode);
        }
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    public static String requestAPI(String tid, Map<String, Object> data, CloseableHttpClient httpclient, int sheet) {
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        String getorpost = ((String) apiData.get(2)).toLowerCase();
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = (String) apiData.get(5);
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        logger.info(stringBuffer);
        if (getorpost.equals("post")) {
            httpResponse = HttpUtils.getInstance().post(stringBuffer.toString(), data, httpclient, null);
        }
        if (getorpost.equals("get")) {
            httpResponse = HttpUtils.getInstance().get(stringBuffer.toString(), data, httpclient, null);
        }
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    public static String requestAPI(String tid, Map<String, Object> data, int sheet, String urlpath) {
        CloseableHttpResponse httpResponse = null;
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        String getorpost = ((String) apiData.get(2)).toLowerCase();
        String scheme = (String) apiData.get(3);
        String apiHost = (String) apiData.get(4);
        String apiPath = urlpath;
        StringBuffer stringBuffer = new StringBuffer(scheme + "://" + apiHost + apiPath);
        logger.info(stringBuffer);
        if (getorpost.equals("post")) {
            httpResponse = HttpUtils.getInstance().post(stringBuffer.toString(), data, BackgroundBaseTest.client, null);
        }
        if (getorpost.equals("get")) {
            httpResponse = HttpUtils.getInstance().get(stringBuffer.toString(), data, BackgroundBaseTest.client, null);
        }
        ResponseBean rb = new ReponseUtil().setResponseBean(httpResponse);
        return rb.getBody().toString();
    }

    /**
     * 获取外部数据源csv的ResponseJson记录
     * @param tid 测试编号
     * @param sheet 数据源sheet
     * @return 以字符串形式返回ResponseJson的记录值
     */
    public static String getCsvResponseJson(String tid, int sheet) {
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        return String.valueOf(apiData.get(6));
    }

    /**
     * 获取外部数据源csv的Path记录
     * @param tid 测试编号
     * @param sheet 数据源sheet
     * @return 以字符串形式返回ResponseJson的记录值
     */
    public static String getCsvPath(String tid, int sheet) {
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        return String.valueOf(apiData.get(5));
    }

    public static String getCsvTID(Integer tid, Integer sheet) {
        String path = ConfigLocation.getApiPath();
        ExcelProvider.filepath = path;
        ExcelSheetName(sheet);
        List<?> apiData = getApiData(tid);
        return String.valueOf(apiData.get(0));
    }
}


