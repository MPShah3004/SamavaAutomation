package com.samava.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = ".//*[@id='myselect']/div/input")
    private WebElement amountList;

    @FindBy(xpath = ".//*[@id='myselect2']/div/input")
    private WebElement durationList;

    @FindBy(xpath = ".//*[@id='myselect3']/div")
    private WebElement categoryList;

    @FindBy(id = "forwardButtonskg")
    private WebElement nextButton;

    @FindBy(xpath = "//i[@class='user icon orange']")
    private WebElement loginIconButton;

    @FindBy(id = "signonForm.email")
    private WebElement userNameTextBox;

    @FindBy(id = "signonForm.password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement userNamePasswordSubmitButton;

    public void enterSearchCriteria(Integer amount, Integer duration, String purpose) {
        waitForElementToBeClickable(amountList);
        selectValueFromList(amountList, amount.toString());
        selectValueFromList(durationList, duration.toString());
        selectValueFromList(categoryList, purpose);
    }

    public void clickOnNext() {
        clickOnElement(nextButton);
    }

    public void enterCredentials(String userName, String password) {
        clickOnElement(loginIconButton);
        enterTextTo(userNameTextBox, userName);
        enterTextTo(passwordTextBox, password);
        clickOnElement(userNamePasswordSubmitButton);
    }
}
