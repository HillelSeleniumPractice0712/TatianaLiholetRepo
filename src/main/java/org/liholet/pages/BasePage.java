package org.liholet.pages;

import org.liholet.driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {

    @FindBy(css = ".ico-login")
    protected WebElement logInLink;

    public BasePage() {
        PageFactory.initElements(WebDriverHolder.getDriver(), this);

    }

    public void clickButton(WebElement element) {
        element.click();
    }

}


    

   

