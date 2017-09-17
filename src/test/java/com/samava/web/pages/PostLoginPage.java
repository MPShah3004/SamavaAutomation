package com.samava.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostLoginPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='red']")
    private WebElement errorLablel;

    public boolean hasErrorMessage() {
        return waitForElementToBeVisible(errorLablel, 5);
    }
}
