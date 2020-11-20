package com.automation.seleniumdocker.configurations;

import com.automation.seleniumdocker.settings.AppConfigKeys;
import com.automation.seleniumdocker.interfaces.IConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 21, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class AppConfigReader implements IConfig {
    private final Properties properties = new Properties();
    private final String userDir;

    public AppConfigReader() throws IOException {
        String configPath = "\\src\\test\\java\\resources\\global.properties";
        userDir = System.getProperty("user.dir");
        FileInputStream inputStream = new FileInputStream(userDir + configPath);
        properties.load(inputStream);
    }

    @Override
    public BrowserTypes getBrowserTypes() {
        String browser = properties.getProperty(AppConfigKeys.browser);
        return BrowserTypes.valueOf(browser);
    }

    @Override
    public String getEnvironment() {
        return properties.getProperty(AppConfigKeys.environment);
    }

    @Override
    public String getURL() {
        return properties.getProperty(AppConfigKeys.url);
    }

    @Override
    public String getHubUrl(){
        return properties.getProperty(AppConfigKeys.hubUrl);
    }

    @Override
    public String getAPIBaseURL() {
        return properties.getProperty(AppConfigKeys.apiBaseURL);
    }
}
