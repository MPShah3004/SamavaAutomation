package com.lieferando.web.stepdefs;


import com.lieferando.web.actor.Actor;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressOrPostcodeSearchStepdef implements En {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public Actor kelly = new Actor("Kelly");

    public AddressOrPostcodeSearchStepdef() {

        Given("^Kelly is looking for good restaurants nearby$", () -> {
            String stepDef = "Kelly is looking for good restaurants nearby";
            LOGGER.info(stepDef);
            kelly.launchBrowser();
        });

        Given("^launches \"([^\"]*)\"$", (String url) -> {
            String stepDef = "launches " + url;
            LOGGER.info(stepDef);
            kelly.openURL(url);
        });

        When("^Kelly searches restaurants by \"([^\"]*)\"$", (String searchBy) -> {
            String stepDef = "Kelly searches restaurants by " + searchBy;
            LOGGER.info(stepDef);
            kelly.searchRestaurants(searchBy);
        });

        When("^She selects any of locality$", () -> {
            String stepDef = "She selects any of locality";
            LOGGER.info(stepDef);
            kelly.picksAnyLocalityFromList();
        });

        Then("^She should get list of restaurants in selected area$", () -> {
            String stepDef = "She should get list of restaurants in selected area";
            LOGGER.info(stepDef);
            kelly.shouldGetListOfRestaurants();
        });

        When("^Kelly searches restaurants by providing invalid \"([^\"]*)\"$", (String searchBy) -> {
            String stepDef = "Kelly searches restaurants by providing invalid " + searchBy;
            LOGGER.info(stepDef);
            kelly.searchRestaurants(searchBy);
        });

        Then("^She should not get any options near by locality$", () -> {
            String stepDef = "She should not get any options near by locality";
            LOGGER.info(stepDef);
            kelly.shouldNotGetAnyOptionsNearBy();
        });


    }
}
