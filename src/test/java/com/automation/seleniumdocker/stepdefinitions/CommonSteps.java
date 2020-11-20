package com.automation.seleniumdocker.stepdefinitions;

import com.automation.seleniumdocker.exceptions.DriverTypeUndefinedException;
import com.automation.seleniumdocker.support.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import  static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class CommonSteps extends BaseClass {

    public CommonSteps() throws IOException, DriverTypeUndefinedException {
    }

    @Then("I wait for {int} seconds")
    public void i_wait_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }
    @When("I sent an api get request to {string} with data param {string} and {string} and I should see status code {string}")
    public void i_sent_api_request_to_endpoint_with_data(String endpoint, String username, String password, String code) throws IOException {
        baseURI = getAPIBaseURL();
        int statusCode = Integer.parseInt(code);

        given()
                .header("username",username)
                .header("password", password)
                .when()
                .get(baseURI+endpoint)
                .then()
                .assertThat().statusCode(statusCode)
                .and()
                .body("headers.Username", equalTo(username))
                .and()
                .body("headers.Password", equalTo(password));

    }
}
