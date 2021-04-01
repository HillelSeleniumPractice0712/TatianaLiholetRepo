package Test;

import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    private static final String BASE_LINK = "http://54.37.125.177/";

    @BeforeMethod
    public void testSetUp() {
        driver = new WebDriverFactory().initDriver();
        driver.manage().window().maximize();
        driver.get(BASE_LINK);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}