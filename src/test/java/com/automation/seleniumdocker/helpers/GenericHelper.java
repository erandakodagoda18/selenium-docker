package com.automation.seleniumdocker.helpers;

import com.automation.seleniumdocker.settings.ObjectRepository;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class GenericHelper {
    public static void waitUntilElementToBeVisible(WebElement element){
        ObjectRepository.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(ObjectRepository.driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement elm = wait.until(driver -> element);
    }
    public static boolean IsElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
    public static void scrollToElement(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) ObjectRepository.driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(ObjectRepository.driver);
        actions.moveToElement(element)
                .build()
                .perform();
    }
    public static void doubleClickOnElement(WebElement element){
        Actions actions = new Actions(ObjectRepository.driver);
        actions.doubleClick(element)
                .build()
                .perform();
    }
    public static void dragAndDropToElement(WebElement sourceElm, WebElement targetElm){
        Actions actions = new Actions(ObjectRepository.driver);
        actions.dragAndDrop(sourceElm,targetElm)
                .build()
                .perform();
    }
}
