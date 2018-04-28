package com.wesai.httpUtils;

import java.io.UnsupportedEncodingException;

public class UrlUtil {
    private final static String ENCODE = "UTF-8";

    /**
     * URL 解码
     * @param str 传入的解码字符
     * @return
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL 转码
     * @param str 传入的转码字符
     * @return
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "第期";
        System.out.println(getURLDecoderString(str));
        System.out.println(getURLEncoderString(str));
    }
}
