package com.krishna.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extentReports;
    public static ExtentReports getReporterObject() {
        //ExtentSparkReport, ExtentReports
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentSparkReporter.config().setReportName("Web Automation Results");
        //Extent Report
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Krishna");
        return extentReports;
    }
}
