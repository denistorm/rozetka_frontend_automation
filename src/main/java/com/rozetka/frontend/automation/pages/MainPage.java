package com.rozetka.frontend.automation.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private By findInputFieldLocator = By.cssSelector(".search-form__input");
    private By findButtonLocator = By.cssSelector("button.button:nth-child(2)");
    private static By loginLinkLocator = By.cssSelector(".header-topline__user-link");
    private static By userNameLocator = By.cssSelector(".header-topline__user-link");

    public MainPage clickLoginButton() {
        $(loginLinkLocator).click();
        return this;
    }

    public MainPage assertUserNameIsDisplayedInHeader(String userName) {
        $(userNameLocator).shouldBe(Condition.text(userName));
        return this;
    }

    public MainPage enterItemNameInTheFindInputField(String itemName) {
        $(findInputFieldLocator).setValue(itemName);
        return this;
    }

    public MainPage clickFindButton() {
        $(findButtonLocator).click();
        return this;
    }

//    public MainPage clickOnFoundItem() {
//        $(findButtonLocator).click();
//        return this;
//    }

}