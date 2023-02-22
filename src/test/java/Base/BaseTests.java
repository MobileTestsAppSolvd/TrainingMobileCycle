package Base;

import binding_TestRail.TestRailManager;
import com.google.common.io.Files;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;

public class BaseTests implements IAbstractTest {
    protected String TestcaseID;

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) getDriver();
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Throwable {
        if (result.getStatus() == ITestResult.SUCCESS) {
            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String error = String.valueOf(result.getThrowable());
            System.out.println("error: " + error);
            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_FAILED_STATUS, error);
        }
    }
}