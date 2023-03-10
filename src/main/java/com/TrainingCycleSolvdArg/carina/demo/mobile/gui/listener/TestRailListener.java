package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener;

import binding_TestRail.*;
import com.qaprosoft.carina.core.foundation.report.testrail.ITestRailManager;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.zebrunner.carina.utils.R;
import net.minidev.json.JSONObject;
import org.json.XML;
import org.testng.*;
import org.testng.internal.ConfigurationGroupMethods;
import org.testng.internal.ITestResultNotifier;
import org.testng.internal.invokers.ITestInvoker;
import org.testng.internal.invokers.TestMethodArguments;
import org.testng.xml.XmlMethodSelector;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestRailListener extends TestRailManager implements ITestListener, ITestRailManager , ISuiteListener, IInvokedMethodListener {

    @Override
    public void onTestStart(ITestResult result) {
        //creamos el test run
/*        ITestContext context = result.getTestContext();
        try {
            createTestRailRun(context, result);
        } catch (IOException | APIException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testRailResultUpdate(result, TestRailManager.TEST_CASE_PASSED_STATUS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testRailResultUpdate(result, TestRailManager.TEST_CASE_FAILED_STATUS);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testRailResultUpdate(result, TestRailManager.TEST_CASE_BLOCKED_STATUS);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
    }


    public void custom(ITestResult result) {
  /*      //creamos el test run
        ITestContext context = result.getTestContext();
        onStart(context);
        try {
            createTestRailRun(context, result);
        } catch (IOException | APIException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            createTestRailRun(suite);
        } catch (IOException | APIException e) {
            throw new RuntimeException(e);
        }

        XmlSuite exel = suite.getXmlSuite();

        String className=suite.getXmlSuite().getTests().get(0).getXmlClasses().get(0).getName();
        String methodName=suite.getXmlSuite().getTests().get(0).getXmlClasses().get(0).getIncludedMethods().get(0)
                .getName();

        System.out.println(className);
        System.out.println(methodName);


    }
}

