package com.automation.seleniumdocker.helpers;

import com.automation.seleniumdocker.settings.ObjectRepository;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class WindowHelper {
    public static String getPageTitle(){
        return ObjectRepository.driver.getTitle();
    }
}
