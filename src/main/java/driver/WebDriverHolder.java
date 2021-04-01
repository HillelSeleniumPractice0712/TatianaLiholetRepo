package driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class WebDriverHolder {
        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        private WebDriverWait wait;
        private static WebDriverHolder instance = null;

        public static WebDriverHolder getInstance() {
            if (instance == null) {
                instance = new WebDriverHolder();
            }
            return instance;
        }

        private  WebDriverHolder() {
        }

        public static WebDriver getDriver() {
            return driver.get();
        }

        public static JavascriptExecutor getJSExecutor() {
            return (JavascriptExecutor)getDriver();
        }

        public void initDriver() {
            if (Objects.isNull(driver.get()))
                driver.set(WebDriverFactory.initDriver());
            wait = new WebDriverWait(driver.get(), 10);
        }

        public WebDriverWait getWaiter(){
            return wait;
        }
    }
