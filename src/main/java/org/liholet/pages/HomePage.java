package org.liholet.pages;

import org.liholet.driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//a[@class = 'ico-login']")
    public WebElement logInLink;

    @FindBy(xpath = ".//a[@class = 'ico-logout']")
    public WebElement logOutLink;

    public HomePage() {
        super();
    }






}