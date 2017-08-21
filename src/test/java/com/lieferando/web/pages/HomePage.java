package com.lieferando.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends AbstractPage {

    @FindBy(id = "imysearchstring")
    private WebElement searchTextBox;

    @FindBy(id = "submit_deliveryarea")
    private WebElement searchSubmitButton;

    @FindBy(id = "reference")
    private WebElement locality;

    @FindBy(id = "reference")
    private List<WebElement> listOfLocality;


    public void searchForRestaurants(String searchString) {
        LOGGER.debug("Title is " + driver.getTitle());
        clickOnElement(searchTextBox);
        enterTextTo(searchTextBox, searchString);
    }

    public void selectOptionsFromList() {
        if (waitForElementToBeVisible(locality)) {
            LOGGER.debug("Total options available from lists are " + listOfLocality.size());
            Random randomized = new Random();
            clickOnElement(listOfLocality.get(randomized.nextInt(listOfLocality.size() - 1)));
        }
    }

    public boolean notHaveRecommendations() {
        LOGGER.debug("Has commendations " + listOfLocality.size());
        return listOfLocality.size() == 0;
    }
}
