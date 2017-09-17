package com.samava.web.stepdefs;

import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDef extends BaseStepDef implements En {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public LoginStepDef() {
        When("^Kelly entered invalid credential$", () -> {
            String stepDef = "Kelly entered invalid credential";
            LOGGER.info(stepDef);
            kelly.enterInvalidCredentials();
        });
        Then("^She should not allow to access the system$", () -> {
            String stepDef = "She should not allow to access the system";
            LOGGER.info(stepDef);
            kelly.shouldNotAllowed();
        });
    }
}
