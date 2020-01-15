package com.rozetka.frontend.automation.popups;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInSignUpPopup {

    private By emailFieldLocator = By.cssSelector("#auth_email");
    private By passwordFieldLocator = By.cssSelector("#auth_pass");
    private By loginButtonLocator = By.cssSelector(".auth-modal__submit");
    private By invalidPasswordErrorMessageLocator = By.cssSelector(".error-message_color_red");
    private By captchaBlockLocator = By.cssSelector("#rc-anchor-container");
    private By captchaCheckBoxLocator = By.cssSelector(".recaptcha-checkbox-border");

    public LogInSignUpPopup enterUserEmail(String userEmail) {
        $(emailFieldLocator).setValue(userEmail);
        return this;
    }

    public LogInSignUpPopup enterUserPassword(String userPassword) {
        $(passwordFieldLocator).setValue(userPassword);
        return this;
    }

    public LogInSignUpPopup clickLoginButton() {
        $(loginButtonLocator).click();
        return this;
    }

    public LogInSignUpPopup assertPasswordErrorMessageAppeared() {
        $(invalidPasswordErrorMessageLocator).shouldBe(Condition.visible);
        return this;
    }

    public LogInSignUpPopup passCaptcha() {
        if ($(captchaBlockLocator).isDisplayed()) {
            $(captchaCheckBoxLocator).click();
        }
        return this;
    }

}
