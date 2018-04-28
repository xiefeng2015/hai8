package com.wesai.utils;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

    public static String findPropertiesKey(String key) {
        try {
            Properties prop = getUserProperties();
            return prop.getProperty(key);
        } catch (Exception e) {
            return "";
        }
    }
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream in = PropertiesUtils.class
                .getResourceAsStream("/config.properties");
        try {
            prop.load(in);
            Iterator<Map.Entry<Object, Object>> itr = prop.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<Object, Object> e = (Map.Entry<Object, Object>) itr.next();
                System.err.println((e.getKey().toString() + "" + e.getValue()
                        .toString()));
            }
        } catch (Exception e) {}
    }

    /**
     * 加载用户自定义配置文件
     * @return
     */
    public static Properties getUserProperties(){
        Properties prop = new Properties();
        String savePath = System.getProperty("user.dir") + File.separator  + "config" + File.separator + "user.properties";
        try {
            InputStream in =new BufferedInputStream(new FileInputStream(savePath));
            prop.load(new InputStreamReader(in, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return prop;
    }

    public static Properties getProperties(){
        Properties prop = new Properties();
        String savePath = PropertiesUtils.class.getResource("/config.properties").getPath();
        //以下方法读取属性文件会缓存问题
//		InputStream in = PropertiesUtils.class
//				.getResourceAsStream("/config.properties");
        try {
            InputStream in =new BufferedInputStream(new FileInputStream(savePath));
            prop.load(in);
        } catch (Exception e) {
            return null;
        }
        return prop;
    }

    public static Properties getjdbcProperties(){
        Properties prop = new Properties();
        String savePath = PropertiesUtils.class.getResource("/jdbc.properties").getPath();
        //以下方法读取属性文件会缓存问题
//		InputStream in = PropertiesUtils.class
//				.getResourceAsStream("/config.properties");
        try {
            InputStream in =new BufferedInputStream(new FileInputStream(savePath));
            prop.load(in);
        } catch (Exception e) {
            return null;
        }
        return prop;
    }

    /**
     * 写入properties信息
     *
     * @param key
     *            名称
     * @param value
     *            值
     */
    public static void modifyProperties(String key, String value) {
        try {
            // 从输入流中读取属性列表（键和元素对）
            Properties prop = getProperties();
            prop.setProperty(key, value);
            String path = PropertiesUtils.class.getResource("/config.properties").getPath();
            FileOutputStream outputFile = new FileOutputStream(path);
            prop.store(outputFile, "modify");
            outputFile.close();
            outputFile.flush();
        } catch (Exception e) {}
    }

}
