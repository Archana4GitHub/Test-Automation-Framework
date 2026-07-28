package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class is responsible for creating and configuring the HTML Report.
 * Think of it as the "Setup" file for our beautiful test reports.
 */
public class ExtentManager {

	// The main engine that builds the report
	private static ExtentReports extent;

	/**
	 * This method creates the HTML report file and sets up how it looks.
	 * We use "synchronized" to ensure that if multiple tests run at the same time,
	 * they don't corrupt the report file.
	 */
	public static synchronized ExtentReports getInstance() {

		// If the report hasn't been created yet, let's build it!
		if (extent == null) {

			// 1. Tell the system WHERE to save the HTML file
			String reportPath = System.getProperty("user.dir") + "/test-output/DTOS-Test-Report.html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

			// 2. Configure the look and feel of the report (Title, Name, Dark Theme)
			sparkReporter.config().setDocumentTitle("DTOS Automation Report");
			sparkReporter.config().setReportName("DTOS Functional Testing Suite");
			sparkReporter.config().setTheme(Theme.DARK);

			// 3. Attach the configuration to the main ExtentReports engine
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			// 4. Add some extra information to the report dashboard (System Info)
			extent.setSystemInfo("Client", "BMWGROUP JAPAN");
			extent.setSystemInfo("QA Engineer", "ARCHANA"); // Put your name here!
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
		}

		// Return the fully configured report engine
		return extent;
	}
}


