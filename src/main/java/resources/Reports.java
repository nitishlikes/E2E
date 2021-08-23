package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	static ExtentReports extent;

	public static ExtentReports getReports() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter r = new ExtentSparkReporter(path);
		r.config().setDocumentTitle("Test Results");
		r.config().setReportName("Automation Results");
		extent = new ExtentReports();
		extent.attachReporter(r);
		extent.setSystemInfo("Tester", "Nitish Kumar");
		return extent;
	}
}
