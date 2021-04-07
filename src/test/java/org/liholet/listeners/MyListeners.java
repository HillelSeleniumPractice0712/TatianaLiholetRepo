package org.liholet.listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.liholet.constants.Constants;
import org.liholet.driver.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyListeners implements ITestListener {
        @Override
        public void onTestStart(ITestResult iTestResult) {

        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {

        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            if(!iTestResult.isSuccess()){
                File screenShot = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
                File dest = new File(Constants.SCREENSHOT_FOLDER, iTestResult.getName() + " " + new Date().getTime() + ".png");
                try {
                    FileUtils.copyFile(screenShot, dest);
                } catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    getScreenShotAsByteArray(iTestResult);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        }

        @Override
        public void onStart(ITestContext iTestContext) {

        }

        @Override
        public void onFinish(ITestContext iTestContext) {

        }

        @Attachment(value = "Page screenshot", type = "image/png")
        private byte[] getScreenShotAsByteArray(ITestResult iTestResult) throws IOException{
            File fileForCopy = new File(iTestResult.getName() + ".jpg");
            File screenshotFile = ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, fileForCopy);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return FileUtils.readFileToByteArray(fileForCopy);
        }

    }

