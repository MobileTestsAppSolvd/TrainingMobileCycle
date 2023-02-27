package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener;

import binding_TestRail.TestRailManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestRailListener implements ITestListener {

    protected String TestcaseID;

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        result.getStatus() == ITestResult.SUCCESS)
        TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
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
