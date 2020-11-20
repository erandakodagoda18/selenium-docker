package com.automation.seleniumdocker.interfaces;

import com.automation.seleniumdocker.configurations.BrowserTypes;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 21, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public interface IConfig {
    BrowserTypes getBrowserTypes();
    String getEnvironment();
    String getURL();
    String getHubUrl();
    String getAPIBaseURL();
}
