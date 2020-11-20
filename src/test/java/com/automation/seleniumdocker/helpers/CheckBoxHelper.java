package com.automation.seleniumdocker.helpers;

import org.openqa.selenium.WebElement;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class CheckBoxHelper {
    public static void checkCheckBox(WebElement element){
        element.click();
    }
    public static boolean isCheckBoxChecked(WebElement element){
        String flag = element.getAttribute("checked");
        return flag != null;
    }
}
