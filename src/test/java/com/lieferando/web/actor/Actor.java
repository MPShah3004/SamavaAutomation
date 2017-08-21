package com.lieferando.web.actor;

import com.lieferando.web.businessflow.SearchRestaurants;
import com.lieferando.web.util.ContextManager;
import com.lieferando.web.util.DriverFactory;
import com.lieferando.web.util.KEYS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class Actor {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private ContextManager contextManager = ContextManager.getInstance();

    private DriverFactory driverFactory;

    private String actorName;

    public Actor(String actorName) {
        LOGGER.debug("Initializing actor");
        this.actorName = actorName;
    }


    private void loadConfigPropertiesToContext() {
        try {
            LOGGER.debug("Loading automation properties");
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResource("Lieferando.properties").openStream());
            contextManager.addToContext(KEYS.BROWSER_TYPE, System.getProperty("browser.type"));
            contextManager.addToContext(KEYS.GECKO_DRIVER_PATH, properties.getProperty("firefox.driver.path"));
            contextManager.addToContext(KEYS.CHROME_DRIVER_PATH, properties.getProperty("chrome.driver.path"));
        } catch (IOException e) {
            LOGGER.debug("Properties file is  missing");
            e.printStackTrace();
        }
    }


    public void searchRestaurants(String searchCriteria) {
        new SearchRestaurants().searchRestaurantsIn(searchCriteria.split(":")[1]);
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
        driverFactory = new DriverFactory();
        try {
            contextManager.addToContext(KEYS.DRIVER, driverFactory.getDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shouldGetListOfRestaurants() {
        new SearchRestaurants().verifyListOfRestaurants();
    }

    public void picksAnyLocalityFromList() {
        new SearchRestaurants().selectRandomLocalityFromList();
    }

    public void shouldNotGetAnyOptionsNearBy() {
        new SearchRestaurants().verifySearchRecommendations();
    }

}
