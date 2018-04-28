package com.wesai.httpUtils;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CookieUtil {
    // 创建CookieStore实例
    static CookieStore cookieStore = null;
    static Logger logger = Logger.getLogger(CookieUtil.class);

    /*
    * 通过CookieStore储存cookie
    * */
    public CookieStore setCookieStore(HttpResponse httpResponse) {
        logger.info("----setCookieStore");
        cookieStore = new BasicCookieStore();
        Header[] cookieArray = httpResponse.getAllHeaders();
        for (int i = 0; i < cookieArray.length; i++) {
        }
        // PHPSESSID
        String setCookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
        String PHPSESSID = setCookie.substring("PHPSESSID=".length(),
                setCookie.indexOf(";"));
        logger.info("PHPSESSID:" + PHPSESSID);
        // 新建一个Cookie
        BasicClientCookie cookie = new BasicClientCookie("PHPSESSID", PHPSESSID);
        // cookie.setVersion(0);
        cookie.setDomain("cai.pre.wesai.com");
        cookie.setPath("/");
        cookie.setVersion(0);
        cookieStore.addCookie(cookie);
        return cookieStore;
    }

    public static void printResponse(HttpResponse httpResponse)
    {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        logger.info("status:" + httpResponse.getStatusLine());
        logger.info("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            logger.info("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = null;
            try {
                responseString = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("response length:" + responseString.length());
            logger.info("response content:" + responseString.replace("\r\n", ""));
        }
    }
}
