package com.wesai.auth;
import com.wesai.utils.MD5;
import com.wesai.utils.StringUtils;
import com.wesai.utils.Base64;

public class HeaderBasicAccess {
    final static String APP_ID = "5001299b5c21129de1e0f937802febb4";
    final static String APP_SECRET_KEY = "ba27af44-0de1-f374-8983-2253e331bb1c";
    final static String CUR_TIMESTAMP = String.valueOf(System.currentTimeMillis()/1000);

    /**
     * 获取用户头文件信息
     * @return 以加密后认证算法字符串形式返回该用户头文件信息
     */
    public static String getAuthorHeaderInfo() {
        return " Basic " + StringUtils.replaceChar(Base64.getBase64(
                APP_ID + "-" + CUR_TIMESTAMP + ":" + MD5.getMd5(CUR_TIMESTAMP + APP_SECRET_KEY)));
    }

    public static void main(String[] args) {
        System.out.println(HeaderBasicAccess.getAuthorHeaderInfo());
        //System.out.println(" Basic ZThjMGU2NDZlNDg2MGEwMzE4ZWE4ODNjOGQ3NzNiNzYtMTQ4ODc5MjY0MDpiMjFjNzJjYjA1ZDVhYzU1MTU1Y2MzZWMwYjA3MWJiZg==");
    }
}
