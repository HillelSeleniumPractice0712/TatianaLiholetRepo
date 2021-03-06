package org.liholet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "message-error validation-summary-errors")
    private WebElement message;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(css = ".login-button")
    private WebElement loginButton;

    public LoginPage() {
        super();
    }

    public HomePage enterEmail(String emailText) {
        email.clear();
        email.sendKeys(emailText);
        return null;
    }

    public void enterPassword(String passwordText) {
        password.clear();
        password.sendKeys(passwordText);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}