package com.automation.seleniumdocker.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/automation/seleniumdocker/features",
                glue = {"com.automation.seleniumdocker.stepdefinitions","com.automation.seleniumdocker.support"},
                monochrome = true,
                plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"},
                tags = "@apiNui")
public class TestRunner {
}
