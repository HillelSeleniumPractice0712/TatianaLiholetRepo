package Test;

import Constants.Constants;
import driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;

public class BaseTestClass {
    @BeforeSuite
    public void beforeSuite() throws IOException {
        recreateDownloadFolder();
        recreateScreenshotsFolder();
        WebDriverHolder.getInstance().initDriver();
    }

    private void recreateDownloadFolder() throws IOException {
        File downloadFolder = new File(Constants.Download_Folder);
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
        goToUrl(Constants.Base_URL);
    }
}
