package com.automation.seleniumdocker.settings;

import com.automation.seleniumdocker.interfaces.IConfig;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

@Getter
@Setter
public class ObjectRepository {
    public static IConfig config;
    public static WebDriver driver;
}
