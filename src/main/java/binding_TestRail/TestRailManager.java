package binding_TestRail;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.ITestRailManager;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.commons.SpecialKeywords;
import net.minidev.json.JSONObject;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.util.*;

public class TestRailManager implements IAbstractTest, ITestListener, ITestRailManager {
    public static String PROJECT_ID = "1";

    //TestRail status codes: 1=Passed, 2=Blocked, 3=Untested, 4=Retest, 5=Failed
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_BLOCKED_STATUS = 2;
    public static final int TEST_CASE_RETEST_STATUS = 4;
    public static final int TEST_CASE_FAILED_STATUS = 5;

    public void createTestRailRun(ITestContext context, ITestResult result) throws IOException, AccessException, APIException {
        APIClient client = new APIClient(R.TESTDATA.get("testRailURL"));
        client.setUser(R.TESTDATA.get("testRailUsername"));
        client.setPassword(R.TESTDATA.get("testRailPassword"));
        Map<String, Object> data = new HashMap<>();
        data.put("include_all", false);//if we set it true, it will add all test cases to this run

        List<Integer> testCaseIdsList = new ArrayList<>();

        Long suiteID = (long) getTestRailSuiteIdFromSuite(result.getTestContext().getSuite());
        Class<?> testClass;
        try {
            testClass = Class.forName(result.getMethod().getTestClass().getName());

            // We can't use getMethod() because we may have parameterized tests
            // for which we won't know the matching signature
            String methodName = result.getMethod().getMethodName();
            Method testMethod = null;
            Method[] possibleMethods = testClass.getMethods();
            for (Method e : possibleMethods) {
                if (e.getName().equals(methodName)) {
                    testMethod = e;
                    testCaseIdsList.add(Integer.parseInt(e.getAnnotation(TestRailCases.class).testCasesId()));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        Integer[] testCasesIdsArray = new Integer[testCaseIdsList.size()];
        testCaseIdsList.toArray(testCasesIdsArray);

        data.put("case_ids", testCasesIdsArray);
        //the name of the created testRun is generated with the current date and time, e.g:Test Run 28-02-2023 T16:18:43
        data.put("name", "Test Run " + DateFormatting.getCurrentTime());
        JSONObject c = null;
        c = (JSONObject) client.sendPost("add_run/" + TestRailManager.PROJECT_ID, data);
        Long suite_id = Long.parseLong(c.get("id").toString());
        context.setAttribute("suiteId", suite_id);
    }
    public static void testRailResultUpdate (ITestResult result, int status){
        String testCaseID = null;

        ITestContext context = result.getTestContext();
        Long testRunId = (Long) context.getAttribute("suiteId");

        Class<?> testClass;
        try {
            testClass = Class.forName(result.getMethod().getTestClass().getName());

            // We can't use getMethod() because we may have parameterized tests
            // for which we won't know the matching signature
            String methodName = result.getMethod().getMethodName();
            Method testMethod = null;
            Method[] possibleMethods = testClass.getMethods();

            for (Method e : possibleMethods) {
                if (e.getName().equals(methodName)) {
                    testMethod = e;
                    testCaseID = testMethod.getAnnotation(TestRailCases.class).testCasesId();
                    break;
                }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String error = result.getThrowable() == null? "" : String.valueOf(result.getThrowable());

        try {
            TestRailManager.addResultForTestCase(testRunId,testCaseID, status, error);
        } catch (IOException | APIException e) {
            throw new RuntimeException(e);
        }
    }
    public int getTestRailSuiteIdFromSuite(ISuite suite) {
        if (suite.getParameter(SpecialKeywords.TESTRAIL_SUITE_ID) != null) {
            return Integer.parseInt(suite.getParameter(SpecialKeywords.TESTRAIL_SUITE_ID).trim());
        } else if (suite.getAttribute(SpecialKeywords.TESTRAIL_SUITE_ID) != null) {
            //use-case to support unit tests
            return Integer.parseInt(suite.getAttribute(SpecialKeywords.TESTRAIL_SUITE_ID).toString().trim());
        } else {
            return -1;
        }
    }
    public static void addResultForTestCase(Long testRunId,String testCaseId, int status, String error) throws IOException, APIException {
        APIClient client = new APIClient(R.TESTDATA.get("testRailURL"));
        client.setUser(R.TESTDATA.get("testRailUsername"));
        client.setPassword(R.TESTDATA.get("testRailPassword"));
        Map data = new HashMap();
        data.put("status_id", status);
        if (status == 1) {
            data.put("comment", "Test Executed - Status updated automatically via integration with Selenium and Jenkins. Test Succesfully Passed");
        } else if (status == 5) {
            data.put("comment", "Test Executed and Failed - Status updated automatically via integration with Selenium and Jenkins. Error: " + error);
        }
        client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
    }
   }