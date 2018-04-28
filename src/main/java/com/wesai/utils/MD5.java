package com.wesai.utils;

import java.security.MessageDigest;

public class MD5 {
    private static MessageDigest md5 = null;
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return str;
    }

    public static String getMd5(String str) {
        byte[] bs = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for(byte x:bs) {
            if((x & 0xff)>>4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("betCodes=4%2A7%2A56%2A7%2A4%5E&2%2A8%2A9%2A5%2A6%5E&betCount=3&betFeeTotal=600&betPlan=0&continuingBetTotal=1&isAppend=0&isStopAfterWin=0&issueId=%5B%E7%AC%AC17178%E6%9C%9F%5D&multiple=1&playingCode=D5"));
//		System.out.println(md5("mj1"));
    }
}
