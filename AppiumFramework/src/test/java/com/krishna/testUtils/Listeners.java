package com.krishna.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.krishna.utils.AppiumUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends AppiumUtils implements ITestListener {
    ExtentReports extentReports = ExtentReporterNG.getReporterObject();
    ExtentTest test;
    AppiumDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.pass(iTestResult.getMethod().getMethodName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            driver = (AppiumDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.fail(iTestResult.getMethod().getMethodName() + " is failed with error " + iTestResult.getThrowable());
        test.addScreenCaptureFromPath(getScreenshotPath(iTestResult.getMethod().getMethodName(),driver),iTestResult.getMethod().getMethodName());
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
        extentReports.flush();
    }
}
