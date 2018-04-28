package com.wesai.httpUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import com.wesai.model.ResponseBean;
import com.wesai.utils.DateUtil;
import com.wesai.utils.MD5;
import com.wesai.utils.StringUtils;
import com.wesai.auth.HeaderBasicAccess;

public class HttpUtils {
    public static Logger logger = Logger.getLogger(HttpUtils.class);

    ResponseBean messages = null;

    Charset s=Consts.UTF_8;

    public static HttpUtils  getInstance(){
        return new HttpUtils();
    }

    public CloseableHttpResponse authPost(String url, Map<String, Object> params, CloseableHttpClient httpclient, CookieStore cookieStore) {
        UrlEncodedFormEntity entitys = getFormEntity(params);
        HttpPost httppost = new HttpPost(url);
        String authHeader = HeaderBasicAccess.getAuthorHeaderInfo();
        httppost.addHeader("Authorization",authHeader);
        httppost.addHeader("User-Agent"," okhttp/3.4.1");
        httppost.addHeader("Accept-Encoding"," gzip");
        httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        if(cookieStore!=null){
            httppost.setHeader("Cookie", "PHPSESSID=" + cookieStore.getCookies().get(0).getValue().trim());
        }
        httppost.setEntity(entitys);
        return RequestAuthMessages(httppost, httpclient);
    }

    public CloseableHttpResponse post(String url, Map<String, Object> params,CloseableHttpClient httpclient,CookieStore cookieStore){
        UrlEncodedFormEntity entitys = getFormEntity(params);
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        httppost.addHeader("Host","cai.adminpre.wesai.com");
        httppost.addHeader("Connection","Keep-Alive");
        httppost.addHeader("Accept-Encoding","gzip, deflate");
        httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0");
        if(cookieStore!=null){
            httppost.setHeader("Cookie", "PHPSESSID=" + cookieStore.getCookies().get(0).getValue().trim());
        }
        httppost.setEntity(entitys);
        return RequestMessages(httppost, httpclient);
    }

    @SuppressWarnings("unchecked")
    protected String sign(Map<String, ? extends Object> data, String signKey, String timestamp) {
        String string = "", signature = "";
        Map<String, String> resultMap = (StringUtils.sortMapByKey((Map<String, String>) data));
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (entry.getValue() instanceof String) {
                string += entry.getKey()+"="+entry.getValue()+"&";
            }
        }
        string = UrlUtil.getURLEncoderString(string.substring(0,string.length()-1));
        string = string.replace("%3D", "=").replace("%26", "&");
        string = string.indexOf("*") != -1 ? string.replace("*", "%2A"): string;
        string = string.indexOf("[") != -1 ? string.replace("[", "%5B"): string;
        string = string.indexOf("]") != -1 ? string.replace("]", "%5D"): string;
        if (String.valueOf(data.get("betCodes")).contains("&")) {
            string = string.replaceFirst("&", "%26");
        }
        System.out.println(MD5.md5(string));
        signature = MD5.md5(string+timestamp);
        return signature.toUpperCase();
    }

    private Map<String, Object> getSign(Map<String, Object> params) {
        String ts, time, sign;
        //t: 为当前接口请求的10位时间戳，时区统一为中国标准时间：China Standard
        ts = DateUtil.getTimeStamp();
        time = ts;
        //s: 为入参抽样MD5码：
        sign = this.sign(params, "ba27af44-0de1-f374-8983-2253e331bb1c", time);
        HashMap<String, Object> data = new HashMap<>();
        data.put("t", time);
        data.put("s", sign);
        return data;
    }

    public CloseableHttpResponse appPost(String url, Map<String, Object> params,CloseableHttpClient httpclient,String accessToken){
        UrlEncodedFormEntity dataEntitys = getFormEntity(getSign(params));
        //String appUrl = url+"?t="+time+"&s="+sign;
        String appUrl;
        try {
            appUrl = url+'?'+ EntityUtils.toString(dataEntitys,"utf8");
            UrlEncodedFormEntity entitys = getFormEntity(params);
            HttpPost httppost = new HttpPost(appUrl);
            httppost.addHeader("Token",accessToken);
            //httppost.addHeader("Content-Type:","application/x-www-form-urlencoded");
            httppost.setEntity(entitys);
            return RequestMessages(httppost, httpclient);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CloseableHttpResponse appGet(String url, Map<String, Object> params,CloseableHttpClient httpclient,String accessToken){
        UrlEncodedFormEntity dataEntitys = getFormEntity(getSign(params));
        UrlEncodedFormEntity inputEntitys = getFormEntity(params);
        HttpGet httpget = null;
        String appUrl;
        try {
            appUrl = url+'?'+EntityUtils.toString(inputEntitys,"utf8")+"&"+EntityUtils.toString(dataEntitys,"utf8");
            httpget = new HttpGet(appUrl);
            httpget.addHeader("Token",accessToken);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return RequestMessages(httpget, httpclient);
    }

    public CloseableHttpResponse post(String url, Map<String, Object> params,CloseableHttpClient httpclient,CookieStore cookieStore, String keycode){
        UrlEncodedFormEntity entitys = getFormEntity(params);
        HttpPost httppost = new HttpPost(url);
        if(cookieStore != null){
            httppost.setHeader("Cookie", "PHPSESSID=" + cookieStore.getCookies().get(0).getValue().trim());
        }
        httppost.setEntity(entitys);
        return RequestMessages(httppost, httpclient);
    }

    public CloseableHttpResponse get(String url, Map<String, Object> params,CloseableHttpClient httpclient,CookieStore cookieStore){
        UrlEncodedFormEntity entitys = getFormEntity(params);
        HttpGet httpget = null;
        try {
            httpget = new HttpGet(url+'?'+EntityUtils.toString(entitys,"utf8"));
            if(cookieStore != null){
                httpget.setHeader("Cookie", "PHPSESSID="+cookieStore.getCookies().get(0).getValue().trim());
                //httpget.setHeader("Cookie","PHPSESSID=uud1n1g6a7q666ctvqbm0t9mg6; Hm_lvt_84c55d593eb62c608555a3695e8f66aa=1477308837; Hm_lpvt_84c55d593eb62c608555a3695e8f66aa=1477308871");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RequestMessages(httpget, httpclient);
    }

    public UrlEncodedFormEntity getFormEntity(Map<String, Object> params,Charset...ucode){
        Charset f=null;
        if(ucode.equals("")){
            f=Consts.UTF_8;
        }else{
            f=s;
        }
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        try {
            Set<String> keySet = params.keySet();
            for(String key:keySet){
                formparams.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
            }
            UrlEncodedFormEntity entitys = new UrlEncodedFormEntity(formparams,f);
            return entitys;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /*
    * 请求数据
    * */
    public CloseableHttpResponse RequestMessages(HttpUriRequest httpRequest , CloseableHttpClient httpclient){
        CloseableHttpResponse response = null;
        try {
            logger.info("请求地址->"+ httpRequest.getRequestLine().toString());
            //规定请求类型为AJAX方式
            httpRequest.addHeader("X-Requested-With","XMLHttpRequest");
            response = httpclient.execute(httpRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /*
     * 请求认证数据
     * */
    public CloseableHttpResponse RequestAuthMessages(HttpUriRequest httpRequest ,CloseableHttpClient httpclient){
        CloseableHttpResponse response = null;
        try {
            logger.info("请求地址->"+ httpRequest.getRequestLine().toString());
            //规定请求类型为AJAX方式
            httpRequest.addHeader("X-Requested-With","XMLHttpRequest");
            //二次认证请求，防止初始请求失败
            for (int i = 0; i < 2; i++) {
                response = httpclient.execute(httpRequest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
