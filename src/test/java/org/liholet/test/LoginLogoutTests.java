package org.liholet.test;

import org.liholet.constants.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.liholet.pages.BasePage;
import org.liholet.pages.HomePage;
import org.liholet.pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginLogoutTests extends BaseTest {
    private static final String EMAIL = "liholet.ta@gmail.com";
    private static final String PASSWORD = "123456";

    BasePage basePage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        goToUrl(Constants.BASE_URL);
    }


    @Test
    public void successfulLogin() {
        basePage = new BasePage();
        homePage = new HomePage();
        loginPage = new LoginPage();

        basePage.clickButton(homePage.logInLink);
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();


        assertTrue(homePage.logOutLink.isDisplayed());
    }

    @Test
    public void successfulLogaut() {
        basePage = new BasePage();
        homePage = new HomePage();
        loginPage = new LoginPage();

        basePage.clickButton(homePage.logInLink);
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

        assertTrue(homePage.logOutLink.isDisplayed());

        basePage.clickButton(homePage.logOutLink);
        assertTrue(homePage.logInLink.isDisplayed());
        
    }



}




