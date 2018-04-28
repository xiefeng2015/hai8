package com.wesai;

import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class LogConfiguration {

    public static void initLog(String fileName){
        String founctionName = getFunctionName(fileName);
        final String logFilePath = "./result/log" + founctionName + "/" +fileName + ".log";
        Properties prop = new Properties();
        prop.setProperty("log4j.rootLogger","info,toConsole,toFile");
        prop.setProperty("log4j.appender.file.enncoding","UTF-8");
        prop.setProperty("log4j.appender.toConsole","org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target","System.out");
        prop.setProperty("log4j.appender.toConsole.layout","org.apache.log4j.PatternLayout ");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern","[%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");
        prop.setProperty("log4j.appender.toFile", "org.apache.log4j.DailyRollingFileAppender");
        prop.setProperty("log4j.appender.toFile.file", logFilePath);
        prop.setProperty("log4j.appender.toFile.append", "false");
        prop.setProperty("log4j.appender.toFile.Threshold", "info");
        prop.setProperty("log4j.appender.toFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");

        PropertyConfigurator.configure(prop);
    }



    private static String getFunctionName(String fileName) {
        return fileName;
    }
}
