package com.samava.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanOptionPage extends AbstractPage {
    @FindBy(id = "category")
    private WebElement categoryDropDown;

    public boolean isPageLoaded() {
        return waitForElementToBeClickable(categoryDropDown);
    }
}
