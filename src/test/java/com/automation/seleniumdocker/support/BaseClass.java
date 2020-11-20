package com.automation.seleniumdocker.support;

import com.automation.seleniumdocker.configurations.AppConfigReader;
import com.automation.seleniumdocker.exceptions.DriverTypeUndefinedException;
import com.automation.seleniumdocker.settings.ObjectRepository;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
/**
 *  @author : Eranda Kodagoda
 *  @date : October 21, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class BaseClass {
    private static WebDriver driver;
    //Setup browser options
    private static DesiredCapabilities firefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setJavascriptEnabled(true);
        capabilities.merge(options);

        return capabilities;
    }
    private static DesiredCapabilities chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setJavascriptEnabled(true);
        capabilities.merge(options);

        return capabilities;
    }
    private static DesiredCapabilities internetExplorerOptions(){
        InternetExplorerOptions options = new InternetExplorerOptions();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("internet explorer");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setJavascriptEnabled(true);
        capabilities.merge(options);

        return capabilities;
    }

    //Get browser
    public static RemoteWebDriver getChrome() throws IOException {
        AppConfigReader appConfigReader = new AppConfigReader();
        return new RemoteWebDriver(new URL(appConfigReader.getHubUrl()),chromeOptions());
    }
    public static RemoteWebDriver getFireFox() throws IOException {
        AppConfigReader appConfigReader = new AppConfigReader();
        return new RemoteWebDriver(new URL(appConfigReader.getHubUrl()),firefoxOptions());
    }
    public static RemoteWebDriver getInternetExplorer() throws IOException {
        AppConfigReader appConfigReader = new AppConfigReader();
        return new RemoteWebDriver(new URL(appConfigReader.getHubUrl()),internetExplorerOptions());
    }
    public static WebDriver initWebDriver() throws IOException, DriverTypeUndefinedException {
        ObjectRepository.config = new AppConfigReader();
        switch (ObjectRepository.config.getBrowserTypes()){
            case Chrome:
                ObjectRepository.driver = getChrome();
                 return ObjectRepository.driver;
            case Firefox:
                ObjectRepository.driver = getFireFox();
                return ObjectRepository.driver;
            case InternetExplorer:
                ObjectRepository.driver = getInternetExplorer();
                return ObjectRepository.driver;
            case Opera:
                return null;
            default:
                throw new DriverTypeUndefinedException("Invalid Driver Name Specified :"
                        + ObjectRepository.config.getBrowserTypes().toString());
        }

    }
    public void tearDown(){
        if (ObjectRepository.driver != null){
            ObjectRepository.driver.close();
            ObjectRepository.driver.quit();
        }
    }
    public String getAPIBaseURL() throws IOException {
        ObjectRepository.config = new AppConfigReader();
        return ObjectRepository.config.getAPIBaseURL();
    }
}
