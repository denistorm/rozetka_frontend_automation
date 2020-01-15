package com.rozetka.frontend.automation.tests;

import com.codeborne.selenide.*;
import com.rozetka.frontend.automation.pages.Pages;
import com.rozetka.frontend.automation.popups.Popups;
import org.testng.annotations.*;

public class AddItemInShoppingCartTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open(Given.ROZETKA_MAIN_PAGE_URL);
    }

    @AfterClass
    public void tearDown() { Selenide.close(); }

    // positive test
    @Test(priority = 3)
    public void testAddItemInShoppingCart() {
        Pages.mainPage()
                .enterItemNameInTheFindInputField(Given.ITEM_NAME) // tea "Curtis ягодный Cool Berries"
                .clickFindButton();
        Pages.itemPage()
                .clickBuyButton();
        Popups.shoppingCartPopup()
                .assertChosenItemIsShownInShoppingCart(Given.ITEM_NAME);
    }

    @DataProvider(name = "item_quantity_values")
    public Object[][] passwords() {
        return new Object[][]{
                { "2"},
                { "1"},
                { "0"},
                { "-1"},
                { "1000000"}
        };
    }

    // negative test: minimal amount of tea "Curtis ягодный Cool Berries" is 3 (by default)
    @Test(priority = 4, dataProvider = "item_quantity_values")
    public void testEnterUnavailableQuantityForSelectedItem(String itemQuantityValue) {
        Popups.shoppingCartPopup()
                .clearItemQuantity()
                .enterItemQuantity(itemQuantityValue)
                .assertItemQuantityFieldHaveDefaultValue(Given.DEFAULT_ITEM_QUANTITY_VALUE);
    }

}
