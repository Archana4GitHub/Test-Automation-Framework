package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;

/**
 * The TestListener "listens" to the execution of your tests.
 * It automatically records Passes, Fails, and captures screenshots on failure.
 */
public class TestListener implements ITestListener {

	// Grab the reporting engine we built in Task 1
	private static ExtentReports extent = ExtentManager.getInstance();

	// ThreadLocal ensures that if we run parallel tests, the logs don't get mixed up!
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		// This fires once before the whole suite starts. We don't need to do much here.
		System.out.println("Starting Test Suite execution...");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// This fires the second a new @Test starts. 
		// We create a new entry in our HTML report with the name of the test method.
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If the test passes, stamp a green PASS on the report.
		test.get().log(Status.PASS, "Test Passed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If the test fails, stamp a red FAIL and log the exact error message.
		test.get().log(Status.FAIL, "Test Failed. Reason: " + result.getThrowable().getMessage());

		// MAGIC: Automatically take a screenshot and attach it to the report!
		try {
			// We cast our WebDriver to a "TakesScreenshot" object, and grab it as a Base64 string
			String base64Screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
			test.get().addScreenCaptureFromBase64String(base64Screenshot, "Error Screenshot");
		} catch (Exception e) {
			test.get().log(Status.INFO, "Failed to capture screenshot.");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// If a test is skipped, stamp a yellow SKIP on the report.
		test.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		// CRITICAL: This fires at the very end of the suite. 
		// flush() actually writes everything we gathered into the physical HTML file.
		extent.flush();
		System.out.println("Test Suite execution finished. Report generated!");
	}
}

