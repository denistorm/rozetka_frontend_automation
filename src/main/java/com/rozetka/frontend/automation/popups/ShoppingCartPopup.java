package com.rozetka.frontend.automation.popups;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPopup {

    public By firstItemTitleLocator = By.cssSelector(".cart-modal__title");
    public By itemQuantityFieldLocator = By.cssSelector(".cart-modal__calc-input");

    public ShoppingCartPopup assertChosenItemIsShownInShoppingCart(String itemName) {
        String firstItemTitleText = $(firstItemTitleLocator).getText();
        assert firstItemTitleText.contains(itemName);
        return this;
    }

    public ShoppingCartPopup clearItemQuantity() {
        $(itemQuantityFieldLocator).clear();
        return this;
    }

    public ShoppingCartPopup enterItemQuantity(String itemQuantity) {
        $(itemQuantityFieldLocator).setValue(itemQuantity).pressEnter();
        return this;
    }

    public ShoppingCartPopup assertItemQuantityFieldHaveDefaultValue(String defaultItemQuantityValue) {
        String itemQuantityFieldValue = $(itemQuantityFieldLocator).shouldBe(Condition.visible).getValue();
        assert itemQuantityFieldValue.equals(defaultItemQuantityValue);
        return this;
    }

}