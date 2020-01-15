package com.rozetka.frontend.automation.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage {

    private static By buyButtonLocator = By.cssSelector(".buy-button");

    public ItemPage clickBuyButton() {
        $(buyButtonLocator).click();
        return this;
    }

}
