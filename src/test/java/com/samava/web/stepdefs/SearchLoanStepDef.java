package com.samava.web.stepdefs;

import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchLoanStepDef extends BaseStepDef implements En {

    public Logger LOGGER = LogManager.getLogger(this.getClass());


    public SearchLoanStepDef() {

        Given("^Kelly is looking for loan$", () -> {
            String stepDef = "Kelly is looking for good restaurants nearby";
            LOGGER.info(stepDef);
            kelly.launchBrowser();
        });

        Given("^launches \"([^\"]*)\"$", (String url) -> {
            String stepDef = "launches " + url;
            LOGGER.info(stepDef);
            kelly.openURL(url);
        });

        When("^Kelly searches for loan for (\\d+) with repayment (\\d+) for \"([^\"]*)\"$", (Integer amount, Integer duration, String purpose) -> {
            String stepDef = "Kelly searches for loan for " + amount + "with repayment " + duration + " for " + purpose;
            LOGGER.info(stepDef);
            kelly.searchLoanFor(amount, duration, purpose);
        });


        When("^She select any from available options$", () -> {
            String stepDef = "She select any from available options";
            LOGGER.info(stepDef);
            kelly.selectAnyBank();
        });

        Then("^She should get detail information for selected one$", () -> {
            String stepDef = "She should get detail information for selected one";
            LOGGER.info(stepDef);
            kelly.shouldGetDetailForSelectedOption();
        });


    }
}
