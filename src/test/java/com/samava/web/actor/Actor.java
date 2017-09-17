package com.samava.web.actor;

import com.samava.web.businessflow.Login;
import com.samava.web.businessflow.SearchLoan;
import com.samava.web.util.ContextManager;
import com.samava.web.util.DriverFactory;
import com.samava.web.util.KEYS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Actor {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private ContextManager contextManager = ContextManager.getInstance();

    private String actorName;

    public Actor(String actorName) {
        LOGGER.debug("Initializing actor");
        this.actorName = actorName;
    }


    private void loadConfigPropertiesToContext() {
        try {
            LOGGER.debug("Loading automation properties");
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResource("AutomationConfig.properties").openStream());
            contextManager.addToContext(KEYS.BROWSER_TYPE, System.getProperty("browser.type"));
            contextManager.addToContext(KEYS.GECKO_DRIVER_PATH, properties.getProperty("firefox.driver.path"));
            contextManager.addToContext(KEYS.CHROME_DRIVER_PATH, properties.getProperty("chrome.driver.path"));
        } catch (IOException e) {
            LOGGER.debug("Properties file is  missing");
            e.printStackTrace();
        }
    }


    public void openURL(String url) {
        try {
            LOGGER.debug(this.actorName + " is opening the url " + url);
            ((WebDriver) contextManager.get(KEYS.DRIVER)).get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchBrowser() {
        loadConfigPropertiesToContext();
        DriverFactory driverFactory = new DriverFactory();
        try {
            contextManager.addToContext(KEYS.DRIVER, driverFactory.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchLoanFor(Integer amount, Integer duration, String purpose) {
        new SearchLoan().selectLoanFor(amount, duration, purpose);
    }

    public void selectAnyBank() {
        new SearchLoan().getDifferentBanks();
    }

    public void shouldGetDetailForSelectedOption() {
        new SearchLoan().checkPageIsLoaded();
    }

    public void enterInvalidCredentials() {
        new Login().loginWithInvalidCredentials("AbcUser", "Test123");
    }

    public void shouldNotAllowed() {
        new Login().checkErrorMessage();
    }
}
