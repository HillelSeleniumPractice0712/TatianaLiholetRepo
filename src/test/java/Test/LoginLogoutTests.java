package Test;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginLogoutTests extends BaseTest {
    private static final String BASE_LINK = "http://54.37.125.177/";
    private static final String EMAIL = "liholet.ta@gmail.com";
    private static final String PASSWORD = "123456";
    private String assertLoginExpected = "Log in";
    private String assertMyAccountExpected = "My account";

    BasePage basePage;
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void successfulLogin() {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        basePage.clickButton(homePage.logInLink);
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

        assertEquals(driver.getCurrentUrl(), BASE_LINK);
        assertTrue(homePage.logOutLink.isDisplayed());
    }

    @Test
    public void successfulLogaut() {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        basePage.clickButton(homePage.logInLink);
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

        assertEquals(driver.getCurrentUrl(), BASE_LINK);
        assertTrue(homePage.logOutLink.isDisplayed());

        basePage.clickButton(homePage.logOutLink);
        assertTrue(homePage.logInLink.isDisplayed());
        
    }



}




