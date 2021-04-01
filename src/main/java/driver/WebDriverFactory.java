package driver;

import Constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver initDriver(BrowserName browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Map<String,Object> preferences = new HashMap<>();
                preferences.put("profile.default_content_settings.popups", 0);
                preferences.put("download.default_directory", new File(Constants.Download_Folder).getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", preferences);
                driver = new ChromeDriver(options);
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case SAFARI:
                WebDriverManager.chromiumdriver().setup();
                driver = new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver initDriver(){
        String browserName = System.getProperty("browserName", "chrome");
        return initDriver(BrowserName.valueOf(browserName.toUpperCase()));
    }
}