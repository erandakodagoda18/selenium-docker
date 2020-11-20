package com.automation.seleniumdocker.support;

import io.cucumber.java.After;

/**
 *  @author : Eranda Kodagoda
 *  @date : October 22, 2020
 *  @version : 1.0
 *  @copyright : © 2020 Eranda Kodagoda
 *   */

public class Hooks extends BaseClass {
    @After
    public void executeTeardown(){
        tearDown();
    }
}
