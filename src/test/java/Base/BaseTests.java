package Base;

import binding_TestRail.APIClient;
import binding_TestRail.APIException;
import binding_TestRail.TestRailCaseId;
import binding_TestRail.*;
import com.google.common.io.Files;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.R;
import net.minidev.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.Map;


public class BaseTests implements IAbstractTest, ITestListener {
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

    @BeforeClass
    public void createTestRailRun(ITestContext context) throws IOException, AccessException, APIException {

        APIClient client = new APIClient(R.TESTDATA.get("testRailURL"));
        client.setUser(R.TESTDATA.get("testRailUsername"));
        client.setPassword(R.TESTDATA.get("testRailPassword"));
        Map<String,Object> data = new HashMap<>();
        data.put("include_all",false);
        //armar un array con las annotations de los caseId y pasarlo al data.put
        ITestNGMethod[] methodArray = context.getAllTestMethods();
        int[] testCaseIds = new int[methodArray.length];
        for (int i = 0; i < methodArray.length; i++) {
            try {
                Method method = methodArray[i].getRealClass().getMethod(methodArray[i].getMethodName());
                testCaseIds[i] = Integer.parseInt(method.getAnnotation(TestRailCaseId.class).id());
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        data.put("case_ids", testCaseIds);
        data.put("name", "Test Run " + DateFormatting.getCurrentTime());
        JSONObject c = null;
        c = (JSONObject) client.sendPost("add_run/" + TestRailManager.PROJECT_ID, data);
        Long suite_id = Long.parseLong(c.get("id").toString());
        context.setAttribute("suiteId",suite_id);
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) throws Throwable {
//        if (result.getStatus() == ITestResult.SUCCESS) {
//            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
//        } else if (result.getStatus() == ITestResult.FAILURE) {
//            String error = String.valueOf(result.getThrowable());
//            System.out.println("error: " + error);
//            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_FAILED_STATUS, error);
//        } else if (result.getStatus()==ITestResult.SKIP) {
//            TestRailManager.addResultForTestCase(TestcaseID, TestRailManager.TEST_CASE_BLOCKED_STATUS, "");
//        }
//    }
    public void skipTestException(String message){
        throw new SkipException(message);
    }
}