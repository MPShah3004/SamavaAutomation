package com.samava.web.pages;

import com.samava.web.util.ContextManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private WebDriver driver;

    AbstractPage() {
        ContextManager contextManager = ContextManager.getInstance();
        driver = contextManager.driver();
        PageFactory.initElements(driver, this);
    }

    void clickOnElement(WebElement webElement) {
        clickOnElement(webElement, 30);
    }

    private void clickOnElement(WebElement webElement, int timeout) {
        LOGGER.debug("clicking on " + webElement.toString());
        if (waitForElementToBeClickable(webElement, timeout)) {
            webElement.click();
        }
    }

    void enterTextTo(WebElement webElement, String textValue) {
        enterTextTo(webElement, textValue, 30);
    }

    private void enterTextTo(WebElement webElement, String textValue, int timeout) {
        LOGGER.debug("Enter " + textValue + " in  " + webElement.toString());
        if (waitForElementToBeClickable(webElement, timeout)) {
            webElement.sendKeys(textValue);
        }
    }

    boolean waitForElementToBeVisible(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (TimeoutException | NoSuchElementException ex) {
            LOGGER.debug("Element not found " + webElement.toString());
            return false;
        }
    }

    boolean waitForElementToBeVisible(WebElement webElement) {
        return waitForElementToBeVisible(webElement, 10);
    }

    private boolean waitForElementToBeClickable(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (TimeoutException | NoSuchElementException ex) {
            LOGGER.debug("Element not visible " + webElement.toString());
            return false;
        }
    }

    boolean waitForElementToBeClickable(WebElement webElement) {
        return waitForElementToBeClickable(webElement, 30);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    void selectValueFromList(WebElement listName, String value) {
        clickOnElement(listName);
        enterTextTo(listName, value);
    }
}
