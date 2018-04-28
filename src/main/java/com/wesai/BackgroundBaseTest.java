package com.wesai;

import com.wesai.LogConfiguration;
import com.wesai.excelUtils.CsvDataProvider;
import com.wesai.httpUtils.HttpUtils;
import com.wesai.utils.ConfigLocation;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import com.wesai.DoBetAPI;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
public class BackgroundBaseTest {

    public static CookieStore cookieStore;
    public static CloseableHttpClient client;
    protected HttpUtils httpUtils = HttpUtils.getInstance();
    public static Logger logger = Logger.getLogger(BackgroundBaseTest.class);
    public static boolean islogin;
    public String methodName;
    public static ApplicationContext ctx;
    public String responseBody;
    public static DoBetAPI doBetAPI;
    protected String playingCode;

    //获取外部数据源
    public Map<String,Object> getUserData(String transfer) throws IOException {
        Class<?> clazz = null;
        String superName;
        if (!islogin) {
            superName = this.getClass().getName();
        }else {
            try {
                String className = this.getClass().getName();
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            superName = clazz.getSuperclass().getName();
        }
        return new CsvDataProvider().dataProvider(superName, transfer);
    }

    @BeforeMethod
    public void StartTest(Method method) throws IOException {
        methodName = method.getName();
        if (!islogin) {
            LogConfiguration.initLog(this.getClass().getSimpleName());
            ctx = ConfigLocation.getContextLocation();
            client = HttpClients.createDefault();
            islogin = true;
        }
    }

    public String getPlayingCode() {
        return playingCode;
    }

    public void setPlayingCode(String playingCode) {
        this.playingCode = playingCode;
    }
}
