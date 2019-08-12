package com.automation.test.framework.Configs;

import org.apache.commons.configuration2.CompositeConfiguration;

public class ConfigProvider {
    private static ConfigProvider instance;
    private static CompositeConfiguration configuration;

    public static ConfigProvider getConfiguration(){
        if(instance ==null){
            synchronized (ConfigProvider.class){
                if(instance == null){
                    instance =new ConfigProvider();
                }
            }
        }
        return instance;
    }

    public String getString(String key){
//        return ofNullable(configuration.getString(key)).orElseThrow(
//            ()-> new RuntimeException(String.format("%s property is not found", key)));
        return key;
    }
}
