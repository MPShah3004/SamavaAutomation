package com.lieferando.web.stepdefs;


import com.lieferando.web.util.ContextManager;
import com.lieferando.web.util.KEYS;
import com.lieferando.web.util.ScreenShotUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Hooks {
    private ContextManager contextManager = ContextManager.getInstance();

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @Before
    public void init(Scenario scenario) {
        String scenarioStartMessage = "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\tScenario: '" + scenario.getName() + "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\n";
        LOGGER.debug(scenarioStartMessage);
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioEndMessage = "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\tExecuted scenario  " + scenario.getName() + "\n " +
                "\tStatus : " + scenario.getStatus() + "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\n";
        LOGGER.debug(scenarioEndMessage);
        ScreenShotUtils.embedScreenShotInReport(scenario, scenario.getName());
        ((WebDriver) contextManager.get(KEYS.DRIVER)).quit();
    }
}
