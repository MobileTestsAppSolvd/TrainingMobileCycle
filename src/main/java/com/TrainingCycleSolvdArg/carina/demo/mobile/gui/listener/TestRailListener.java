package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener;

import binding_TestRail.APIException;
import binding_TestRail.TestRailCaseId;
import binding_TestRail.TestRailManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestRailListener implements ITestListener {

    public static String TestcaseID;

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);


    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // ITestListener.super.onTestSuccess(result);
       testRailResultUpdate(result,TestRailManager.TEST_CASE_PASSED_STATUS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testRailResultUpdate(result,TestRailManager.TEST_CASE_FAILED_STATUS);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testRailResultUpdate(result,TestRailManager.TEST_CASE_BLOCKED_STATUS);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context){

    }
}
