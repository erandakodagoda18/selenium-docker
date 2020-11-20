package com.automation.seleniumdocker.pageObjects;

import com.automation.seleniumdocker.helpers.GenericHelper;
import com.automation.seleniumdocker.settings.ObjectRepository;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject {/*
 * Constructor and Initiating the Page Factory
 * */
    public PageObject(){
        PageFactory.initElements(ObjectRepository.driver,this);
    }
    /*
     * Element Locators
     * */
    @FindBy(css = "form > div:nth-child(1) > input")
    private WebElement nameTxtField;
    @FindBy(name = "email")
    private WebElement emailTxtField;
    @FindBy(id = "exampleInputPassword1")
    private WebElement passwordField;
    @FindBy(id = "exampleCheck1")
    private WebElement loveIceCreamCheckBox;
    @FindBy(id = "exampleFormControlSelect1")
    private WebElement genderSelector;
    @FindBy(id = "inlineRadio2")
    private WebElement employedRadioBtn;
    @FindBy(name = "bday")
    private WebElement dobPicker;
    @FindBy(css = "form > input")
    private WebElement submitBtn;


    /*
     * Page methods
     * */

    public PageObject setName(String name){
        GenericHelper.waitUntilElementToBeVisible(nameTxtField);
        this.nameTxtField.sendKeys(name);
        return this;
    }
    public PageObject setEmail(String email){
        GenericHelper.waitUntilElementToBeVisible(emailTxtField);
        this.emailTxtField.sendKeys(email);
        return this;
    }
    public PageObject setPassword(String password){
        GenericHelper.waitUntilElementToBeVisible(passwordField);
        this.passwordField.sendKeys(password);
        return this;
    }
    public PageObject checkCheckBox(){
        GenericHelper.waitUntilElementToBeVisible(loveIceCreamCheckBox);
            this.loveIceCreamCheckBox.click();

        return this;
    }
    public PageObject selectGender(String gender){
        GenericHelper.waitUntilElementToBeVisible(genderSelector);
        Select select = new Select(genderSelector);
        select.selectByVisibleText(gender);
        return this;
    }
    public PageObject selectEmployeed(){
        GenericHelper.waitUntilElementToBeVisible(employedRadioBtn);
        this.employedRadioBtn.click();
        return this;
    }
    public PageObject setDob(String date){
        GenericHelper.waitUntilElementToBeVisible(dobPicker);
        this.dobPicker.sendKeys(date);
        return this;
    }
    public void clickSubmitBtn(){
        GenericHelper.waitUntilElementToBeVisible(submitBtn);
        this.submitBtn.click();
    }
    public void fillTheForm(String name,
                            String email, String password,
                            String gender, String dob){
        this.setName(name)
                .setEmail(email)
                .setPassword(password)
                .checkCheckBox()
                .selectGender(gender)
                .selectEmployeed()
                .setDob(dob)
                .clickSubmitBtn();
    }
}
