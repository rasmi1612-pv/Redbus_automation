package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
                ExtentManager.getInstance().createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("🟢 TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());

        ExtentTestManager.getTest().fail("🔴 TEST FAILED");
        ExtentTestManager.getTest().fail(result.getThrowable());

        try {
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("❌ Screenshot attach cheyyan pattiyilla");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("🟠 TEST SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
