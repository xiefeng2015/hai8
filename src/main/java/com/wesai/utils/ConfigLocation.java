package com.wesai.utils;

import java.io.File;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConfigLocation {
    private static String configLocation;
    private static ApplicationContext ctx;

    public static ApplicationContext getContextLocation() {
        configLocation = System.getProperty("user.dir") + File.separator  + "resources" + File.separator + "spring-application.xml";
        //ctx = new FileSystemXmlApplicationContext(configLocation);
        return ctx;
    }

    public static String getApiPath() {
        configLocation = System.getProperty("user.dir") + File.separator  + "resources" + File.separator + "api.xls";
        return configLocation;
    }
}
