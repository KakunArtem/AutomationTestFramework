package com.automation.test.framework.configs;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import static java.util.Optional.ofNullable;

public class ConfigProvider {
    private static final String API_CONFIG_FILE = "apiConfig.properties";
    private static final String WEB_CONFIG_FILE = "webConfig.properties";
    private static ConfigProvider instance;

    private static CompositeConfiguration configuration;

    private ConfigProvider() {
        configuration = new CompositeConfiguration();
        try {
            configuration.addConfiguration(new PropertiesConfiguration(API_CONFIG_FILE));
            configuration.addConfiguration(new PropertiesConfiguration(WEB_CONFIG_FILE));
        } catch (ConfigurationException exception) {
            throw new IllegalStateException("Failed to load configuration file");
        }
    }

    public static ConfigProvider getConfiguration() {
        if (instance == null) {
            synchronized (ConfigProvider.class) {
                if (instance == null) {
                    instance = new ConfigProvider();
                }
            }
        }
        return instance;
    }

    public String getString(String key) {
        return ofNullable(configuration.getString(key))
                .orElseThrow(() -> new RuntimeException(String.format("%s property is not found", key)));
    }
}
