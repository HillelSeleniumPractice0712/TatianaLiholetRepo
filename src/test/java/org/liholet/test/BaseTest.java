package org.liholet.test;

import org.liholet.constants.Constants;
import org.liholet.driver.WebDriverFactory;
import org.liholet.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.liholet.listeners.MyListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners(MyListeners.class)

public class BaseTest {
    WebDriver driver;
    private static final String BASE_LINK = "http://54.37.125.177/";

    @BeforeMethod
    public void testSetUp() {
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get(BASE_LINK);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() throws IOException {
        recreateDownloadFolder();
        recreateScreenshotsFolder();
        WebDriverHolder.getInstance().initDriver();
    }

    private void recreateDownloadFolder() throws IOException {
        File downloadFolder = new File(Constants.DOWNLOAD_FOLDER);
        if (downloadFolder.exists()) {
            FileUtils.forceDelete(downloadFolder);
        }
        FileUtils.forceMkdir(downloadFolder);
    }

    private void recreateScreenshotsFolder() throws IOException {
        File screenshotsFolder = new File(Constants.SCREENSHOT_FOLDER);
        if (screenshotsFolder.exists()) {
            FileUtils.forceDelete(screenshotsFolder);
        }
        FileUtils.forceMkdir(screenshotsFolder);
    }

    @AfterSuite
    public void afterSuite() {
        if (WebDriverHolder.getDriver() != null) {
            WebDriverHolder.getDriver().quit();
        }
    }

    public void goToUrl(String url) {
        WebDriverHolder.getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(Constants.BASE_URL);
    }
}





