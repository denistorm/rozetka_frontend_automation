package com.rozetka.frontend.automation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.rozetka.frontend.automation.pages.Pages;
import com.rozetka.frontend.automation.popups.Popups;
import org.testng.annotations.*;

public class LogInTest {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open(Given.ROZETKA_MAIN_PAGE_URL);
    }

    @BeforeClass
    public void openLogInSignUpPopup() {
        Pages.mainPage()
                .clickLoginButton();
    }

    @AfterTest
    public void tearDown() {
        Selenide.close();
    }

    // only two invalid values are used because after the third try validation by Captcha is appeared
    @DataProvider(name = "invalid_passwords")
    public Object[][] passwords() {
        return new Object[][]{
                { "admin"},
                { "qwerty"},
                //{ "test"},
                //{ "*#"},
                //{ " "}
        };
    }

    // negative test: invalid password input
    @Test(priority = 1, dataProvider = "invalid_passwords")
    public void testLogInWithInvalidPassword(String password) {
        Popups.logInSignUpPopup()
                .enterUserEmail(Given.USER_EMAIL)
                .enterUserPassword(password)
                .clickLoginButton()
                .assertPasswordErrorMessageAppeared();

    }

    // positive test
    @Test (priority = 2)
    public void testLogInWithCorrectCredentials() {
        Popups.logInSignUpPopup()
                .enterUserEmail(Given.USER_EMAIL)
                .enterUserPassword(Given.USER_PASSWORD)
                .clickLoginButton();
        Pages.mainPage()
                .assertUserNameIsDisplayedInHeader(Given.USER_NAME);
    }

}
