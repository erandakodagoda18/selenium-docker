package com.automation.seleniumdocker.helpers;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class ComboBoxHelper {
    private static Select select;

    public static void selectByIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
    }
    public static void selectByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
    }
    public static List<String> getAllOptions(WebElement element){
        select = new Select(element);
        List<WebElement> opt = select.getOptions();
        List<String> list = new ArrayList<>();
        for (WebElement option:opt) {
            list.add(option.getText());
        }
        return list;
    }
}
