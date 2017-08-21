package com.lieferando.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {

    @FindBy(id = "irestaurantlist")
    private WebElement listOfRestaurants;


    public boolean hasListOfRestaurants() {
        return waitForElementToBeVisible(listOfRestaurants);
    }

}
