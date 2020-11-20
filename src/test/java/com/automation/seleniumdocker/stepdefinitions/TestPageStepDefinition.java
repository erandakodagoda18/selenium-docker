package com.automation.seleniumdocker.stepdefinitions;

import com.automation.seleniumdocker.configurations.AppConfigReader;
import com.automation.seleniumdocker.exceptions.DriverTypeUndefinedException;
import com.automation.seleniumdocker.pageObjects.PageObject;
import com.automation.seleniumdocker.support.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestPageStepDefinition extends BaseClass {
    private final WebDriver driver = initWebDriver();
    private final PageObject testPageObject = new PageObject();
    private Percy percy;

    public TestPageStepDefinition() throws IOException, DriverTypeUndefinedException {
    }
    @Given("I am on app form page")
    public void i_am_on_app_login_page() throws IOException {
        AppConfigReader appConfigReader = new AppConfigReader();
        assert driver != null;
        driver.get(appConfigReader.getURL());
        percy = new Percy(driver);
        percy.snapshot("Test Page");
    }
    @When("I submitted data into the form as {string} , {string} , {string} , {string} , {string}")
    public void i_submitted_data_into_form(String name, String email, String password,
                                           String gender, String dob){
        testPageObject.fillTheForm(name,email,password,gender,dob);
    }
}
