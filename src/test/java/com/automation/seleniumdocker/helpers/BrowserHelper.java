package com.automation.seleniumdocker.helpers;

import com.automation.seleniumdocker.settings.ObjectRepository;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class BrowserHelper {
    public static void maximize(){
        ObjectRepository.driver.manage().window().maximize();
    }
    public static void minimize(){
        ObjectRepository.driver.manage().window().maximize();
    }
    public static void navigateForward(){
        ObjectRepository.driver.navigate().forward();
    }
    public static void navigateBackward(){
        ObjectRepository.driver.navigate().back();
    }
    public static void refreshPage(){
        ObjectRepository.driver.navigate().refresh();
    }
    public static void switchToChildWindow(){
        String parentWindow = ObjectRepository.driver.getWindowHandle();
        Set<String> windows = ObjectRepository.driver.getWindowHandles();
        for (String window: windows) {
            if (!window.equals(parentWindow)){
                ObjectRepository.driver.switchTo().window(window);
                ObjectRepository.driver.manage().window().maximize();
            }
        }
    }
    public static void switchToFrame(WebElement element){
        ObjectRepository.driver.switchTo().frame(element);
    }
}
