package com.wesai.utils;

import com.wesai.json.MapKeyComparator;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String replaceChar(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static int subZeroString(String str) {
        String newStr = str.replaceAll("^(0+)", "");
        return Integer.parseInt(newStr);
    }

    /**
     * 使用 Map按key进行排序
     * @param data
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(data);
        return sortMap;
    }

    public static void main(String[] args) {
        String str = "000000001234034120";
        System.out.println(StringUtils.subZeroString(str));
        System.out.println(StringUtils.replaceChar("just do it!"));
    }
}
