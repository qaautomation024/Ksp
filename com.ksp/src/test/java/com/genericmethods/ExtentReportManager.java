package com.genericmethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize the report
    public static void initReport() {
    	ExtentSparkReporter sparkReporter  = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Start a new test
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    // Log messages
    public static void log(String message) {
        test.info(message);
    }

    // Log pass messages
    public static void logPass(String message) {
        test.pass(message);
    }

    // Log fail messages
    public static void logFail(String message) {
        test.fail(message);
    }

    // Add screenshots if needed
    public static void addScreenshot(String screenshotPath) {
        test.addScreenCaptureFromPath(screenshotPath);
    }

    // Finalize the report
    public static void finalizeReport() {
        extent.flush();
    }
}